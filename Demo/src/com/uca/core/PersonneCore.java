package src.com.uca.core;
import src.com.uca.dao.PersonneDAO;
import src.com.uca.entity.Personne;

import java.util.ArrayList;

public class PersonneCore {

    public static ArrayList<Personne> getAllPersonnes() {
        return new PersonneDAO().getAllPersonnes();
    }

    public static Personne getPersonneByNum(int numero) {
        return new PersonneDAO().getPersonneByNum(numero);
    }

    public static Personne getPersonneByNom(String nom) {
        return new PersonneDAO().getPersonneByNom(nom);
    }

    public static void savePersonne(Personne personne) {
        new PersonneDAO().create(personne);
    }

    public static void deletePersonneByNum(int num) {
        new PersonneDAO().deletePersonneByNum(num);
    }

    

}