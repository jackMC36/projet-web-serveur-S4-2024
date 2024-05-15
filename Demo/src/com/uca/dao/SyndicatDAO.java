package src.com.uca.dao;

import src.com.uca.core.PersonneCore;
import src.com.uca.entity.Personne;
import src.com.uca.entity.Syndicat;

import java.sql.*;
import java.util.ArrayList;

public class SyndicatDAO extends _Generic<Syndicat> {

    public SyndicatDAO(){
        //ignore
    }

    public ArrayList<Syndicat> getAllSyndicats() {
        ArrayList<Syndicat> syndicats = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Syndicat ORDER BY NOM ASC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Syndicat entity = new Syndicat();
                entity.setNom(resultSet.getString("nom"));
                entity.setMail(resultSet.getString("adresse_mail"));
                entity.setAdresse(resultSet.getString("adresse"));
                entity.setNumTel(resultSet.getInt("numeroTel"));

                PersonneDAO pe = new PersonneDAO();

                if(pe.isPersonneExist(resultSet.getInt("numeroTel"))){
                    entity.setReferent(new PersonneDAO().getPersonneByNum(resultSet.getInt("numeroTel")));
                }
                else{
                    Personne p = new Personne(resultSet.getString("nom_referent"), "", resultSet.getInt("numeroTel"));
                    PersonneCore.savePersonne(p);
                    entity.setReferent(new PersonneDAO().getPersonneByNum(resultSet.getInt("numeroTel")));
                }

                syndicats.add(entity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return syndicats;
    }

    public Syndicat getSyndicatByMail(String mail) {
        Syndicat entity = null;
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Syndicat WHERE mail = ? ORDER BY NOM ASC");
            preparedStatement.setString(1, mail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = new Syndicat();
                entity.setNom(resultSet.getString("nom"));
                entity.setMail(resultSet.getString("adresse_mail"));
                entity.setAdresse(resultSet.getString("adresse"));
                entity.setNumTel(resultSet.getInt("numeroTel"));
                entity.setReferent(new PersonneDAO().getPersonneByNum(resultSet.getInt("numeroTel")));

                PersonneDAO personneDAO = new PersonneDAO();
                Personne personne = personneDAO.getPersonneByNom(resultSet.getString("nom_referent"));
                entity.setReferent(personne);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return entity;
    }

    public Syndicat getSyndicatByNom(String nom) {
        Syndicat entity = null;
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Syndicat WHERE nom = ? ORDER BY NOM ASC");
            preparedStatement.setString(1, nom);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = new Syndicat();
                entity.setNom(resultSet.getString("nom"));
                entity.setMail(resultSet.getString("adresse_mail"));
                entity.setAdresse(resultSet.getString("adresse"));
                entity.setNumTel(resultSet.getInt("numeroTel"));
                entity.setReferent(new PersonneDAO().getPersonneByNum(resultSet.getInt("numeroTel")));

                PersonneDAO personneDAO = new PersonneDAO();
                Personne personne = personneDAO.getPersonneByNom(resultSet.getString("nom_referent"));
                entity.setReferent(personne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void deleteSyndicatByAdresse(String adresse) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Syndicat WHERE adresse = ?");
            preparedStatement.setString(1, adresse);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveSyndicat(String nom, String adresse, String prenomRef, String nomRef, int numReferent, int numTel, String mail) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Syndicat (nom, adresse_mail, adresse, numeroTel, nom_referent) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, mail);
            preparedStatement.setString(3, adresse);
            preparedStatement.setInt(4, numTel);
            preparedStatement.setString(5, nomRef);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Syndicat create(Syndicat obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Syndicat (nom, adresse_mail, adresse, numeroTel, nom_referent) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getMail());
            preparedStatement.setString(3, obj.getAdresse());
            preparedStatement.setInt(4, obj.getNumTel());
            preparedStatement.setString(5, obj.getReferent().getNom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Syndicat obj) {
        // nous n'utilisons pas cette méthode pour notre suppression mais nous sommes obligés de la définir
    }
}
