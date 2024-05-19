package src.com.uca.core;

import src.com.uca.dao.OccupationDAO;
import src.com.uca.entity.Occupation;
import src.com.uca.entity.Personne;

import java.util.ArrayList;

public class OccupationCore {

    public static ArrayList<Personne> getAllProprietaire(int numeroAppt, String adresseAppt) {
        return new OccupationDAO().getAllProprietaire(numeroAppt, adresseAppt);
    }

    public static ArrayList<Personne> getAllLocataire(int numeroAppt, String adresseAppt) {
        return new OccupationDAO().getAllLocataire(numeroAppt, adresseAppt);
    }

    public static void delete(Occupation occupation) {
        new OccupationDAO().delete(occupation);
    }

    public static void save(Occupation occupation) {
        new OccupationDAO().create(occupation);
    }
}