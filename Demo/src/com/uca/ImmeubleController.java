package com.uca.demo;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.uca.SQL;
import com.uca.Immeuble;

import java.util.List;

@Controller
public class ImmeubleController {
    @Autowired
    private SQL sql;

    @GetMapping("/immeubles")
    public String getAllImmeubles(Model model) {
        List<Immeuble> immeubles = sql.getAllImmeubles();
        model.addAttribute("immeubles", immeubles);
        return "immeubles";
    }
}