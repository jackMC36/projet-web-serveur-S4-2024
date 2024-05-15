package src.com.uca;

import src.com.uca.dao._Initializer;
import src.com.uca.gui.*;

import static spark.Spark.*;

public class StartServer {

    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);

        _Initializer.Init();

        //Defining our routes
        get("/immeubles", (req, res) -> {
            return ImmeubleGUI.getAllImmeubles();
        });

        post("/deleteImmeuble", (req, res) -> {
            return ImmeubleGUI.deleteImmeubleByAdresse(req.queryParams("adresse"));
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

        get("/occupations", (req, res) -> {
            return OccupationGUI.getInfo(req);
        });

        post("/deleteProprietaire", (req, res) -> {
            return OccupationGUI.deleteProprietaire(req);
        });

        get("/createProprietaire", (req, res) -> {
            return OccupationGUI.createProprietaire(req);
        });

        post("/saveProprietaire", (req, res) -> {
            return OccupationGUI.saveProprietaire(req);
        });

        post("/deleteLocataire", (req, res) -> {
            return OccupationGUI.deleteLocataire(req);
        });

        get("/createLocataire", (req, res) -> {
            return OccupationGUI.createLocataire(req);
        });

        post("/saveLocataire", (req, res) -> {
            return OccupationGUI.saveLocataire(req);
        });

        get("/stats", (req, res) -> {
            return StatsGUI.getAllStats(req);
        });
    }
}