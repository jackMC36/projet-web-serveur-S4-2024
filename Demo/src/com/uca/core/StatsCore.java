package src.com.uca.core;

import src.com.uca.entity.Immeuble;
import src.com.uca.dao.StatsDAO;

import java.util.ArrayList;

public class StatsCore {

    public static ArrayList<Integer> getInfosLogement(int numeroTel) {
        return new StatsDAO().getInfosLogement(numeroTel);
    }

    public static ArrayList<Integer> getInfosLogementByImmeuble(int numeroTel, String adresse) {
        return new StatsDAO().getInfosLogementByImmeuble(numeroTel, adresse);
    }

    public static ArrayList<Immeuble> getAllImmeublesByProprietaire(int numeroTel) {
        return new StatsDAO().getAllImmeublesByProprietaire(numeroTel);
    }
}