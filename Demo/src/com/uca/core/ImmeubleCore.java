package src.com.uca.core;

import src.com.uca.dao.ImmeubleDAO;
import src.com.uca.entity.Immeuble;

import java.util.ArrayList;

public class ImmeubleCore {

    public static ArrayList<Immeuble> getAllImmeubles() {
        return new ImmeubleDAO().getAllImmeubles();
    }

    public static void deleteImmeubleByAdresse(String adresse) {
        new ImmeubleDAO().deleteImmeubleByAdresse(adresse);
    }

    public static void saveImmeuble(Immeuble immeuble) {
        new ImmeubleDAO().create(immeuble);
    }
}