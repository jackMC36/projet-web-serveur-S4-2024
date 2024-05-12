package src.com.uca.dao;

import src.com.uca.entity.Immeuble;
import src.com.uca.entity.Personne;
import src.com.uca.entity.Syndicat;

import java.sql.*;
import java.util.ArrayList;


public class ImmeubleDAO extends _Generic<Immeuble> {

    public ArrayList<Immeuble> getAllImmeubles() {
        ArrayList<Immeuble> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Immeuble ORDER BY NOM ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Immeuble entity = new Immeuble();
                entity.setNom(resultSet.getString("nom"));
                entity.setAdresse(resultSet.getString("adresse"));
    
                SyndicatDAO syndicatDAO = new SyndicatDAO();
                Syndicat syndicat = syndicatDAO.getSyndicatByNom(resultSet.getString("syndicat"));
                entity.setSyndicat(syndicat);
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public Immeuble getImmeubleByNom(String nom) {
        Immeuble immeuble = null;
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Immeuble WHERE nom = ?;");
            preparedStatement.setString(1, nom);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Immeuble entity = new Immeuble();
                entity.setNom(resultSet.getString("nom"));
                entity.setAdresse(resultSet.getString("adresse"));
    
                SyndicatDAO syndicatDAO = new SyndicatDAO();
                Syndicat syndicat = syndicatDAO.getSyndicatByNom(resultSet.getString("syndicat"));
                entity.setSyndicat(syndicat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return immeuble;
    }

    public void deleteImmeubleByNom(String nom) {
        try {
            PreparedStatement preparedStatement1 = this.connect.prepareStatement("SELECT adresse FROM Immeuble WHERE nom = ?;");
            preparedStatement1.setString(1, nom);
            ResultSet resultSet = preparedStatement1.executeQuery();
            if (resultSet.next()) {
                String adresse = resultSet.getString("adresse");
    
                PreparedStatement preparedStatement2 = this.connect.prepareStatement("DELETE FROM Appartement WHERE adresse = ?;");
                preparedStatement2.setString(1, adresse);
                preparedStatement2.executeUpdate();
    
                PreparedStatement preparedStatement3 = this.connect.prepareStatement("DELETE FROM Immeuble WHERE nom = ?;");
                preparedStatement3.setString(1, nom);
                preparedStatement3.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Immeuble create(Immeuble obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Immeuble (nom, adresse, syndicat) VALUES (?, ?, ?);");
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getAdresse());
            if("".equals(obj.getSyndicatNom())) {
                throw new IllegalArgumentException("SyndicatNom cannot be empty");
            } else {
                preparedStatement.setString(3, obj.getSyndicatNom());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Immeuble obj) {
        try {
            PreparedStatement preparedStatement1 = this.connect.prepareStatement("DELETE FROM Appartement WHERE adresse = ?");
            String adresse = obj.getAdresse();
            preparedStatement1.setString(1, adresse);
            preparedStatement1.executeUpdate();

            PreparedStatement preparedStatement2 = this.connect.prepareStatement("DELETE FROM Immeuble WHERE adresse = ?");
            preparedStatement2.setString(1, adresse);
            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}