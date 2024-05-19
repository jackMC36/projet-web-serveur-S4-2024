package src.com.uca;

import src.com.uca.core.ImmeubleCore;
import src.com.uca.dao._Initializer;
import src.com.uca.gui.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import src.com.uca.core.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class StartServer {

    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);

        _Initializer.Init();

        //Defining our routes

        get("/", (req, res) -> {
            Configuration configuration = _FreeMarkerInitializer.getContext();
            Writer output = new StringWriter();
            Template template = configuration.getTemplate("index.ftl");
            template.setOutputEncoding("UTF-8");
            template.process(new HashMap<>(), output);
            return output.toString();
        });

        get("/inscription", (req, res) -> {
            return CompteGUI.inscription();
        });

        get("/connexion", (req, res) -> {
           return CompteGUI.connexion();
        });

        post("/saveCompte", (req, res) -> {
            if (req.queryParams("numTel") == null || req.queryParams("mdp") == null) {
                return "Erreur : veuillez remplir tous les champs";
            }
            if (CompteCore.checkNumberInDB(Integer.parseInt(req.queryParams("numTel")))) {
                return "Erreur : numéro de téléphone déjà enregistré";
            }
            return CompteGUI.saveCompte(Integer.parseInt(req.queryParams("numTel")), req.queryParams("mdp"));
        });

        post("/loginCompte", (req, res) -> {
            if (req.queryParams("numTel") == null || req.queryParams("mdp") == null) {
                return "Erreur : veuillez remplir tous les champs";
            }
            if (!CompteCore.checkNumberInDB(Integer.parseInt(req.queryParams("numTel")))) {
                return "Erreur : numéro de téléphone non enregistré";
            }
            return CompteGUI.loginCompte(Integer.parseInt(req.queryParams("numTel")), req.queryParams("mdp"));
        });
            

        get("/immeubles", (req, res) -> {
            return ImmeubleGUI.getAllImmeubles();
        });

        post("/deleteImmeuble", (req, res) -> {
            return ImmeubleGUI.deleteImmeubleByNom(req.queryParams("Nom"));
        });

        get("/createImmeuble", (req, res) -> {
            return ImmeubleGUI.createImmeuble();
        });

        post("/saveImmeuble", (req, res) -> {
            return ImmeubleGUI.saveImmeuble(req.queryParams("nom"), req.queryParams("adresse"), req.queryParams("syndicatNom"));
        });
        
        get("/appartements", (req, res) -> {
            return AppartementGUI.getAllAppartementsByAdresse(req);
        });

        post("/deleteAppartement", (req, res) -> {
            return AppartementGUI.deleteAppartement(req);
        });

        get("/createAppartement", (req, res) -> {
            return AppartementGUI.createAppartement(req);
        });

        post("/saveAppartement", (req, res) -> {
            return AppartementGUI.saveAppartement(req);
        });
       
        get("/syndicats", (req, res) -> {
            return SyndicatGUI.getAllSyndicats();
        });

        get("/createSyndicat", (req, res) -> {
            return SyndicatGUI.createSyndicat();
        });

        post("/saveSyndicat", (req, res) -> {
            return SyndicatGUI.saveSyndicat(req.queryParams("nom"), req.queryParams("adresse"), req.queryParams("prenomRef"), req.queryParams("nomRef"), Integer.parseInt(req.queryParams("numTel")), req.queryParams("adresse_mail"));
        });

        post("/deleteSyndicat", (req, res) -> {
            return SyndicatGUI.deleteSyndicatByAdresse(req.queryParams("adresse"));
        });

        get("/personnes", (req, res) -> {
            return PersonneGUI.getAllPersonnes();
        });

        get("/createPersonne", (req, res) -> {
            return PersonneGUI.createPersonne();
        });

        post("/savePersonne", (req, res) -> {
            return PersonneGUI.savePersonne(req.queryParams("prenom"), req.queryParams("nom"), Integer.parseInt(req.queryParams("numTel")));
        });

        post("/deletePersonne", (req, res) -> {
            String num = req.queryParams("numTel");
            num = num.replaceAll("[^\\d]", "");
            int numero = Integer.parseInt(num);
            return PersonneGUI.deletePersonneByNum(numero);
        });
    }
}