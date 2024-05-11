package src.com.uca.core;

import src.com.uca.dao.AppartementDAO;
import src.com.uca.entity.Appartement;

import java.util.ArrayList;

public class AppartementCore {

    public static ArrayList<Appartement> getAllAppartementsByAdresse(String adresse) {
        return new AppartementDAO().getAllAppartementsByAdresse(adresse);
    }

    public static void deleteAppartement(int numero, String adresse) {
        new AppartementDAO().deleteAppartement(numero, adresse);
    }

    public static void saveAppartement(Appartement appartement) {
        new AppartementDAO().create(appartement);
    }
}