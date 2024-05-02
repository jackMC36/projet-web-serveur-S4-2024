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

    @Override
    public Immeuble create(Immeuble obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Immeuble (nom, adresse, syndicat) VALUES (?, ?, ?);");
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getAdresse());
            preparedStatement.setString(3, obj.getSyndicatNom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }

    @Override
    public void delete(Immeuble obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Immeuble WHERE nom = ?;");
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
}