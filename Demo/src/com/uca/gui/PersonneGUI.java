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

public class PersonneGUI {

    public static String getAllPersonnes() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("Personnes", PersonneCore.getAllPersonnes());

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
        input.put("Personnes", PersonneCore.getAllPersonnes());
    
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("personnes.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
        
        return output.toString();
    }
    
}