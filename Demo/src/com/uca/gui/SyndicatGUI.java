package src.com.uca.gui;

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

public class SyndicatGUI {

    public static String getAllSyndicats() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("syndicats", SyndicatCore.getAllSyndicats());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("syndicats.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
        
        return output.toString();
    }

    public static String deleteSyndicatByAdresse(String adresse) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
    
        SyndicatCore.deleteSyndicatByAdresse(adresse);
    
        Map<String, Object> input = new HashMap<>();
        input.put("syndicats", SyndicatCore.getAllSyndicats());
    
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("syndicats.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
    
        return output.toString();
    }

    public static String createSyndicat() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
    
        Map<String, Object> input = new HashMap<>();
        input.put("personnes", PersonneCore.getAllPersonnes());
    
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("newsyndicat.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
    
        return output.toString();
    }

    public static String saveSyndicat(String nom, String adresse,String prenomRef, String nomRef, int numTel, String adresse_mail) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        // Check si la Personne existe
        Personne personne = PersonneCore.getPersonneByNum(numTel);
        if (personne == null) {
            return "Erreur: aucune personne n'a été trouvé sous la forme NOM = " + nomRef + " et NUMEROTEL = " + numTel + ". Veuillez vous relire. Veuillez ajouter la personne avant de créer un syndicat. (Voir l'onglet Personnes)";
        }

        SyndicatCore.saveSyndicat(nom, adresse, prenomRef, nomRef, numTel, adresse_mail);

        Map<String, Object> input = new HashMap<>();
        input.put("syndicats", SyndicatCore.getAllSyndicats());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("syndicats.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    } 
}
