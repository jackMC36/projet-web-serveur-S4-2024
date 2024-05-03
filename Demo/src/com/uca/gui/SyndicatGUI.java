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
    
}
