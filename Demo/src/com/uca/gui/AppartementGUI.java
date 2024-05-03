package src.com.uca.gui;

import src.com.uca.core.AppartementCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class AppartementGUI {

    public static String getAllAppartementsByAdresse() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("appartements", AppartementCore.getAllAppartementsByAdresse());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("appartements.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}

