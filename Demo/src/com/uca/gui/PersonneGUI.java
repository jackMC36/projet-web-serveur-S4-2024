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
import src.com.uca.dao.PersonneDAO;

public class PersonneGUI {

    public static String getAllPersonnes() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("personnes", PersonneCore.getAllPersonnes());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("personnes.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
        
        return output.toString();
    }

    public static String deletePersonneByNum(int num) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        
        PersonneCore.deletePersonneByNum(num);
        
        Map<String, Object> input = new HashMap<>();
        input.put("personnes", PersonneCore.getAllPersonnes());
        
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("personnes.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
        
        return output.toString();
    }


    public static String createPersonne() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("newpersonne.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(new HashMap<>(), output);
        return output.toString();
    }

    public static String savePersonne(String prenom,  String nom, int numTel) throws IOException, TemplateException {

        Personne personne = new Personne();
        personne.setNom(nom);
        personne.setPrenom(prenom);
        personne.setNumTel(numTel);
        PersonneDAO p   = new PersonneDAO();

        if(p.isPersonneExist(numTel)){
            return "Erreur: La personne avec le numéro de téléphone " + numTel + " existe déjà";
        }
        PersonneCore.savePersonne(personne);
        return getAllPersonnes();
    }

    
    
}