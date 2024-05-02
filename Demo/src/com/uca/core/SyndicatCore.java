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

    /* public static void deleteSyndicatByNum(int num)) {
        new SyndicatDAO().deleteSyndicatByNum(num);
    }

    public static void saveSyndicat(Syndicat Syndicat) {
        new SyndicatDAO().create(Syndicat);
    } */

    

}