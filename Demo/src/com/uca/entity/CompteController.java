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

import src.com.uca.dao.CompteDAO;
import src.com.uca.entity.Compte;
import java.io.IOException;
import freemarker.template.TemplateException;
import src.com.uca.core.*;

import java.util.List;

@Controller
public class CompteController {
    private static final Logger logger = LoggerFactory.getLogger(CompteController.class);
    



    @GetMapping("/inscription")
    public static String createCompte() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("inscription.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(new HashMap<>(), output);
        return output.toString();
    }

    @GetMapping("/connexion")
    public static String loginCompte() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("connexion.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(new HashMap<>(), output);
        return output.toString();
    }
    
    @PostMapping("/saveCompte")
    public static String saveCompte(int num_tel, String mdp) {
        Compte newCompte = new Compte(num_tel, mdp);
        CompteCore.create(newCompte);
        return "redirect:/immeubles";
    }

    @PostMapping("/loginCompte")
    public static String loginCompte(int num_tel, String mdp) {
        String res = CompteCore.loginCompte(num_tel, mdp);
        if (res.equals("success")) {
            return "redirect:/immeubles";
        }
        if(res.equals("NumberNotInDB")){
            return "Erreur : Numéro n'est pas dans la base de données";
        }
        if(res.equals("MDPFalse")){
            return "Erreur : Mot de passe incorrect";
        }
        return "redirect:/";
    }
}