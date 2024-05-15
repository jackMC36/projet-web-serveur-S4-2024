package src.com.uca.core;

import src.com.uca.dao.StatsDAO;

import java.util.ArrayList;

public class StatsCore {

    public static ArrayList<Integer> getLogementLoue(int numeroTel) {
        return new StatsDAO().getLogementLoue(numeroTel);
    }

    /*
    public static int getLogementVide() { //est-ce qu'on fait une fonction pour ça OU une soustraction de 100% moins le nb de logement vide ??? Car si un logement n'est pas loué, alors il est forcément libre
        return new StatsDAO().getLogementVide();
    }
    */
}