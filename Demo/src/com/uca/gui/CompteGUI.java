package src.com.uca.gui;


import java.io.IOException;
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
import src.com.uca.dao.*;

public class CompteGUI {

    public CompteGUI() {
        //ignored
    }

    public static String loginCompte(int numTel, String mdp) {
        String res = CompteCore.loginCompte(numTel, mdp);
        if (res.equals("Success")) {
            try {
                return ImmeubleGUI.getAllImmeubles();
            } catch (TemplateException | IOException e) {
                e.printStackTrace();
                return "Erreur : Impossible de récupérer les immeubles";
            }
        }
        if(res.equals("NumberNotInDB")){
            return "Erreur : Numéro n'est pas dans la base de données";
        }   
        if(res.equals("MDPFalse")){
            return "Erreur : Mot de passe incorrect";
        }
    
        return res;
    }

    public static String saveCompte(int numTel, String mdp) throws IOException, TemplateException {
        CompteCore.create(new Compte(numTel, mdp));
        return ImmeubleGUI.getAllImmeubles();
    }

    public static String inscription() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("inscription.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(new HashMap<>(), output);
        return output.toString();
    }

    public static String connexion() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("connexion.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(new HashMap<>(), output);
        return output.toString();
    }
    
}
