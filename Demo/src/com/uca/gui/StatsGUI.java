package src.com.uca.gui;

import src.com.uca.core.StatsCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import src.com.uca.entity.*;
import src.com.uca.core.*;

import spark.Request;

public class StatsGUI {

    public static String getAllStats(Request request) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        int numeroTel = Integer.parseInt(request.queryParams("numeroTel"));
        String prenom = request.queryParams("prenom");

        // on lance la fonction 'getInfosLogement' qui récupère dans un tableau 3 données : le nb totel de logement de la personne, le nb de logement loué et le nombre de logement vide
        ArrayList<Integer> logement = new ArrayList<Integer>();
        logement = StatsCore.getInfosLogement(numeroTel);

        Map<String, Object> input = new HashMap<>();

        input.put("numeroTel", numeroTel);
        input.put("prenom", prenom);
        input.put("nbLogement", logement.get(0));
        input.put("nbLogementLoue", logement.get(1));
        input.put("nbLogementVide", logement.get(2));
        input.put("immeubles", StatsCore.getAllImmeublesByProprietaire(numeroTel));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("stats.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String getStatsByImmeuble(Request request) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        String numero = request.queryParams("numeroTel");
        numero = numero.replaceAll("[^\\d]", ""); // Supprime les caractères non numériques de la chaîne
        int numeroTel = Integer.parseInt(numero);
        String adresse = request.queryParams("adresse");
        String nom = request.queryParams("nom");

        // on lance la fonction 'getInfosLogement' qui récupère dans un tableau 3 données : le nb de logement de la personne dans cet immeuble, le nb de logement loué et le nombre de logement vide (toujours dans cet immeuble)
        ArrayList<Integer> logement = new ArrayList<Integer>();
        logement = StatsCore.getInfosLogementByImmeuble(numeroTel, adresse);

        Map<String, Object> input = new HashMap<>();

        input.put("nom", nom);
        input.put("nbLogement", logement.get(0));
        input.put("nbLogementLoue", logement.get(1));
        input.put("nbLogementVide", logement.get(2));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("statsImmeuble.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
