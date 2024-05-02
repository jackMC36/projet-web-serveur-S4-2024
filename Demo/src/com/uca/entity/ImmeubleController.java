package src.com.uca.entity;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import src.com.uca.dao.ImmeubleDAO;
import src.com.uca.entity.Immeuble;

import java.util.List;

@Controller
public class ImmeubleController {
    @Autowired
    private ImmeubleDAO sql;

    @GetMapping("/immeubles")
    public String getAllImmeubles(Model model) {
        ImmeubleDAO d = new ImmeubleDAO();
        List<Immeuble> immeubles = d.getAllImmeubles();
        model.addAttribute("immeubles", immeubles);
        return "immeubles";
    }

    /*@GetMapping("/immeubles") @PostMapping("/deleteImmeuble")
    public String deleteImmeuble(@RequestParam("immeubleNom") String immeubleId) {
        // logic to delete the immeuble
        return "redirect:/immeubles";
    }

    @GetMapping("/createImmeuble")
    public String createImmeuble(Model model) {
        // logic to create a new immeuble
        return "createImmeuble";
    }*/
}