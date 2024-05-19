package src.com.uca.gui;

import src.com.uca.entity.*;
import src.com.uca.core.AppartementCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import spark.Request;

public class AppartementGUI {

    public static String getAllAppartementsByAdresse(Request request) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        String adresse = request.queryParams("adresse");
        String immeubleNom = request.queryParams("immeubleNom");

        Map<String, Object> input = new HashMap<>();

        input.put("immeubleNom", immeubleNom);
        input.put("adresse", adresse);
        input.put("appartements", AppartementCore.getAllAppartementsByAdresse(adresse));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("appartements.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String deleteAppartement(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        int numero = Integer.parseInt(req.queryParams("numero"));
        String adresse = req.queryParams("adresse");
        String immeubleNom = req.queryParams("immeubleNom");
    
        AppartementCore.deleteAppartement(numero, adresse);
    
        Map<String, Object> input = new HashMap<>();
        input.put("immeubleNom", immeubleNom);
        input.put("adresse", adresse);
        input.put("appartements", AppartementCore.getAllAppartementsByAdresse(adresse));
    
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("appartements.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
    
        return output.toString();
    }

    public static String createAppartement(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        String immeubleNom = req.queryParams("immeubleNom");
        String adresseImmeuble = req.queryParams("adresseImmeuble");

        Map<String, Object> input = new HashMap<>();
        input.put("immeubleNom", immeubleNom);
        input.put("adresseImmeuble", adresseImmeuble);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("newappartement.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
        return output.toString();
    }

    public static String saveAppartement(Request req) throws IOException, TemplateException {
        int etage = Integer.parseInt(req.queryParams("etage"));
        int numero = Integer.parseInt(req.queryParams("numero"));
        float superficie = Float.parseFloat(req.queryParams("superficie"));
        String adresse = req.queryParams("adresse");
        int estLoue = Integer.parseInt(req.queryParams("estLoue"));
        AppartementCore.saveAppartement(new Appartement(etage, numero, superficie, adresse, 0));
        return getAllAppartementsByAdresse(req);
    }
}

