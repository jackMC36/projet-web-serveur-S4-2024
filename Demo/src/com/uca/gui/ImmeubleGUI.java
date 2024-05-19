package src.com.uca.gui;

import src.com.uca.core.ImmeubleCore;
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

public class ImmeubleGUI {

    public static String getAllImmeubles() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("immeubles", ImmeubleCore.getAllImmeubles());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("immeubles.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String deleteImmeubleByAdresse(String adresse) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
    
        ImmeubleCore.deleteImmeubleByAdresse(adresse);
    
        Map<String, Object> input = new HashMap<>();
        input.put("immeubles", ImmeubleCore.getAllImmeubles());
    
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("immeubles.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
    
        return output.toString();
    }

    public static String createImmeuble() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("newimmeuble.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(new HashMap<>(), output);
        return output.toString();
    }

    public static String saveImmeuble(String nom, String adresse, String syndicatNom) throws IOException, TemplateException {
        // Check s'il existe une personne qui possède ce numéro de téléphone
        Syndicat syndicat = SyndicatCore.getSyndicatByNom(syndicatNom);
        if (syndicat == null) {
            return "Erreur : Il n'existe pas de syndicat dans la base qui possède ce nom. Vérifier que vous n'avez pas fait d'erreur ou créer le syndicat avant de réessayer (voir onglet Syndicats).";
        }

        ImmeubleCore.saveImmeuble(new Immeuble(nom, adresse, syndicat));
        return getAllImmeubles();
    }

    public static String syndicats() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("syndicats.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(new HashMap<>(), output);
        return output.toString();
    }

    

    


}
