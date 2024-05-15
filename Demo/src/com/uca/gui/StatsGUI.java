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

        ArrayList<Integer> logement = new ArrayList<Integer>();
        logement = StatsCore.getLogementLoue(numeroTel);

        Map<String, Object> input = new HashMap<>();

        input.put("prenom", prenom);
        input.put("nbLogement", logement.get(0));
        input.put("nbLogementLoue", logement.get(1));
        input.put("nbLogementVide", logement.get(2));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("stats.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
