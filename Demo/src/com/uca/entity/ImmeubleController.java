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

import src.com.uca.dao.ImmeubleDAO;
import src.com.uca.entity.Immeuble;

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
    public String deleteImmeubleByNom(@RequestParam("Nom") String Nom) {
        logger.info("deleteImmeubleByNom called with immeubleNom: {}", Nom);
        
        ImmeubleDAO d = new ImmeubleDAO();
        d.deleteImmeubleByNom(Nom);
    
        return "redirect:/immeubles";
    }





    /*
    @GetMapping("/createImmeuble")
    public String createImmeuble(Model model) {
        // logic to create a new immeuble
        return "createImmeuble";
    } */
}