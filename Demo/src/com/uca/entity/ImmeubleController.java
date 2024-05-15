package src.com.uca.entity;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import src.com.uca.dao._Initializer;
import src.com.uca.gui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.Writer;
import java.io.StringWriter;
import java.util.HashMap;

import src.com.uca.dao.ImmeubleDAO;
import src.com.uca.entity.Immeuble;
import java.io.IOException;
import freemarker.template.TemplateException;
import src.com.uca.core.*;

import java.util.List;

@Controller
public class ImmeubleController {
    private static final Logger logger = LoggerFactory.getLogger(ImmeubleController.class);
    

    @GetMapping("/immeubles")
    public String getAllImmeubles(Model model) {
        ImmeubleDAO d = new ImmeubleDAO();
        List<Immeuble> immeubles = d.getAllImmeubles();
        model.addAttribute("immeubles", immeubles);

        return "immeubles";
    }

    @PostMapping("/deleteImmeuble")
    public String deleteImmeubleByAdresse(@RequestParam("adresse") String adresse) {
        logger.info("deleteImmeubleByAdresse called with adresse: {}", adresse);
        
        ImmeubleDAO d = new ImmeubleDAO();
        d.deleteImmeubleByAdresse(adresse);
    
        return "redirect:/immeubles";
    }

    @GetMapping("/createImmeuble")
    public static String createImmeuble() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("newimmeuble.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(new HashMap<>(), output);
        return output.toString();
    }
    
    @PostMapping("/saveImmeuble")
    public static String saveImmeuble(String nom, String adresse, String syndicatNom) {
        // Create a new Immeuble with the submitted values and save it to the database
        Syndicat syndicat = SyndicatCore.getSyndicatByNom(syndicatNom);
        Immeuble newImmeuble = new Immeuble(nom, adresse, syndicat);
        ImmeubleCore.saveImmeuble(newImmeuble);
        // Redirect the user to the list of immeubles
        return "redirect:/immeubles";
    }
}