package src.com.uca.core;

import src.com.uca.dao.AppartementDAO;
import src.com.uca.entity.Appartement;

import java.util.ArrayList;

public class AppartementCore {

    public static ArrayList<Appartement> getAllAppartementsByAdresse(String adresse) {
        return new AppartementDAO().getAllAppartementsByAdresse(adresse);
    }

}