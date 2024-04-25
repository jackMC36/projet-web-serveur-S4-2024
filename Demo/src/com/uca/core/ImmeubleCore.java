package src.com.uca.core;

import src.com.uca.dao.ImmeubleDAO;
import src.com.uca.entity.Immeuble;

import java.util.ArrayList;

public class ImmeubleCore {

    public static ArrayList<Immeuble> getAllImmeubles() {
        return new ImmeubleDAO().getAllImmeubles();
    }

}