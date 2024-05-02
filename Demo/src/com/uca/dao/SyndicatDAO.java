package src.com.uca.dao;

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

                PersonneDAO personneDAO = new PersonneDAO();
                Personne personne = personneDAO.getPersonneByNom(resultSet.getString("nom_referent"));
                entity.setReferent(personne);

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

                PersonneDAO personneDAO = new PersonneDAO();
                Personne personne = personneDAO.getPersonneByNom(resultSet.getString("nom_referent"));
                entity.setReferent(personne);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Syndicat create(Syndicat obj) {
        //TODO !
        return null;
    }

    @Override
    public void delete(Syndicat obj) {
        //TODO !
    }
}