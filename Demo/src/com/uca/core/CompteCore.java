package src.com.uca.core;

import src.com.uca.dao.CompteDAO;
import src.com.uca.entity.Compte;

public class CompteCore {
    
    public static void delete(Compte obj) {
        new CompteDAO().delete(obj);
    }

    public static Compte create(Compte obj) {
        return new CompteDAO().create(obj);
    }

    public static boolean checkPassword(String providedPassword, String storedPasswordHash) {
        return new CompteDAO().checkPassword(providedPassword, storedPasswordHash);
    }

    public static String hashPassword(String password) {
        return new CompteDAO().hashPassword(password);
    }

    public static void deleteCompteByNumTel(int num_tel) {
        new CompteDAO().deleteCompteByNumTel(num_tel);
    }

    public static String loginCompte(int num_tel, String mdp) {
        return new CompteDAO().loginCompte(num_tel, mdp);
    }

    public static Boolean checkNumberInDB(int num_tel) {
        return new CompteDAO().checkNumberInDB(num_tel);
    }
 
}
