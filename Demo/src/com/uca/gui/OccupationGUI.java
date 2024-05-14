package src.com.uca.gui;

import src.com.uca.core.OccupationCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import src.com.uca.entity.*;
import src.com.uca.core.*;

import spark.Request;

public class OccupationGUI {

    public static String getInfo(Request request) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        int numeroAppt = Integer.parseInt(request.queryParams("numeroAppt"));
        String adresseAppt = request.queryParams("adresseAppt");

        Map<String, Object> input = new HashMap<>();

        input.put("numeroAppt", numeroAppt);
        input.put("adresseAppt", adresseAppt);
        input.put("proprios", OccupationCore.getAllProprietaire(numeroAppt, adresseAppt));
        input.put("locataires", OccupationCore.getAllLocataire(numeroAppt, adresseAppt));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("occupations.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String deleteLocataire(Request request) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        String numero = request.queryParams("numeroTel");
        numero = numero.replaceAll("[^\\d]", ""); // Supprime les caractères non numériques de la chaîne
        int numeroTel = Integer.parseInt(numero);
        int numeroAppt = Integer.parseInt(request.queryParams("numeroAppt"));
        String adresseAppt = request.queryParams("adresseAppt");
    
        OccupationCore.deleteLocataire(new Occupation(numeroTel, "Locataire", numeroAppt, adresseAppt));

        Map<String, Object> input = new HashMap<>();
        input.put("numeroAppt", numeroAppt);
        input.put("adresseAppt", adresseAppt);
        input.put("proprios", OccupationCore.getAllProprietaire(numeroAppt, adresseAppt));
        input.put("locataires", OccupationCore.getAllLocataire(numeroAppt, adresseAppt));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("occupations.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
    
        return output.toString();
    }

    public static String createLocataire(Request request) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        int numeroAppt = Integer.parseInt(request.queryParams("numeroAppt"));
        String adresseAppt = request.queryParams("adresseAppt");

        Map<String, Object> input = new HashMap<>();
        input.put("numeroAppt", numeroAppt);
        input.put("adresseAppt", adresseAppt);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("newlocataire.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
        return output.toString();
    }

    public static String saveLocataire(Request request) throws IOException, TemplateException {
        int numeroTel = Integer.parseInt(request.queryParams("numeroTel"));
        int numeroAppt = Integer.parseInt(request.queryParams("numeroAppt"));
        String adresseAppt = request.queryParams("adresseAppt");
        
        // Check s'il existe une personne qui possède ce numéro de téléphone
        Personne personne = PersonneCore.getPersonneByNum(numeroTel);
        if (personne == null) {
            return "Erreur : Il n'existe personne dans la base qui possède ce numéro. Vérifier que vous n'avez pas fait d'erreur ou créer la personne avant de réessayer (voir onglet Personne).";
        }

        OccupationCore.saveLocataire(new Occupation(numeroTel, "Locataire", numeroAppt, adresseAppt));
        return getInfo(request);
    }
}
