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

import src.com.uca.dao.PersonneDAO;
import src.com.uca.entity.Personne;
import java.io.IOException;
import freemarker.template.TemplateException;
import src.com.uca.core.*;

import java.util.List;

@Controller
public class PersonneController {
    private static final Logger logger = LoggerFactory.getLogger(PersonneController.class);
    
    @GetMapping("/personnes")
    public String getAllPersonnes(Model model) {
        PersonneDAO d = new PersonneDAO();
        List<Personne> Personnes = d.getAllPersonnes();
        model.addAttribute("Personnes", Personnes);

        return "Personnes";
    }

    @PostMapping("/deletePersonne")
    public String deleteImmeubleByNum(@RequestParam("Num") int num) {
        logger.info("deletePersonneByNum called with num: {}", num);
        
        PersonneDAO d = new PersonneDAO();
        d.deletePersonneByNum(num);
    
        return "redirect:/personnes";
    }

    @GetMapping("/createPersonne")
    public String createPersonne() {
        return "newpersonne";
    }
    
    @PostMapping("/savePersonne")
    public String savePersonne(@RequestParam String prenom, @RequestParam String nom, @RequestParam int numTel) {
        // Create a new Immeuble with the submitted values and save it to the database
        Personne p = new Personne();
        p.setPrenom(prenom);
        p.setNom(nom);
        p.setNumTel(numTel);
        PersonneCore.savePersonne(p);

        return "redirect:/personnes";
    }
}