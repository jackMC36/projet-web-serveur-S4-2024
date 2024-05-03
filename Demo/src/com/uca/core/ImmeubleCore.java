package src.com.uca.core;

import src.com.uca.dao.ImmeubleDAO;
import src.com.uca.entity.Immeuble;

import java.util.ArrayList;

public class ImmeubleCore {

    public static ArrayList<Immeuble> getAllImmeubles() {
        return new ImmeubleDAO().getAllImmeubles();
    }

    public static void deleteImmeubleByNom(String nom) {
        new ImmeubleDAO().deleteImmeubleByNom(nom);
    }

    public static void saveImmeuble(Immeuble immeuble) {
        new ImmeubleDAO().create(immeuble);
    }

    

}