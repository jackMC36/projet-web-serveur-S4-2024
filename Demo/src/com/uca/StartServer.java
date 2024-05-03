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

        get("/appartements", (req, res) -> {
            return AppartementGUI.getAllAppartementsByAdresse(req);
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

        get("/syndicats", (req, res) -> {
            return SyndicatGUI.getAllSyndicats();
        });

        post("/deleteSyndicat", (req, res) -> {
            return SyndicatGUI.deleteSyndicatByAdresse(req.queryParams("Adresse"));
        });

        get("/personnes", (req, res) -> {
            return PersonneGUI.getAllPersonnes();
        });

        get("/createPersonne", (req, res) -> {
            return PersonneGUI.createPersonne();
        });

        post("/savePersonne", (req, res) -> {
            return PersonneGUI.savePersonne(req.queryParams("nom"), req.queryParams("prenom"), Integer.parseInt(req.queryParams("numTel")));
        });
    }
}