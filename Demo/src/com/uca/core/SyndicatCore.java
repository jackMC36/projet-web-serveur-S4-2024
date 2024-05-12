package src.com.uca.core;
import src.com.uca.dao.SyndicatDAO;
import src.com.uca.entity.Syndicat;

import java.util.ArrayList;

public class SyndicatCore {

    public static ArrayList<Syndicat> getAllSyndicats() {
        return new SyndicatDAO().getAllSyndicats();
    }

    public static Syndicat getSyndicatByNom(String nom) {
        return new SyndicatDAO().getSyndicatByNom(nom);
    }

    public static void deleteSyndicatByAdresse(String adresse) {
        new SyndicatDAO().deleteSyndicatByAdresse(adresse);
    }

    public static void saveSyndicat(String nom, String adresse,String prenomRef, String nomRef, int numTel, String adresse_mail) {
        new SyndicatDAO().create(new Syndicat(nom, adresse, prenomRef, nomRef, numTel, adresse_mail));
    }
}
