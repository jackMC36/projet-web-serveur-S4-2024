package src.com.uca.core;

import src.com.uca.dao.AppartementDAO;
import src.com.uca.entity.Appartement;

import java.util.ArrayList;

public class AppartementCore {

    public static ArrayList<Appartement> getAllAppartementsByAdresse() {
        return new AppartementDAO().getAllAppartementsByAdresse("1 rue de la paix"); //modifié pour que l'adresse ne soit pas 'statique' mais qu'elle puisse être récupéré ailleurs.
    }

}