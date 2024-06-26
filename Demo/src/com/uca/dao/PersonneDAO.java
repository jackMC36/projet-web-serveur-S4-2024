package src.com.uca.dao;

import src.com.uca.entity.Personne;

import java.sql.*;
import java.util.ArrayList;

public class PersonneDAO extends _Generic<Personne> {

    public ArrayList<Personne> getAllPersonnes() {
        ArrayList<Personne> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Personne ORDER BY NOM ASC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Personne entity = new Personne();
                entity.setNom(resultSet.getString("nom"));
                entity.setPrenom(resultSet.getString("prenom"));
                entity.setNumTel(resultSet.getInt("numeroTel"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public Boolean isPersonneExist(int num) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Personne WHERE numeroTel = ?");
            preparedStatement.setInt(1, num);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Personne getPersonneByNum(int numero) {
        Personne entity = null;
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Personne WHERE numeroTel = ? ORDER BY NOM ASC");
            preparedStatement.setInt(1, numero);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = new Personne();
                entity.setNom(resultSet.getString("nom"));
                entity.setPrenom(resultSet.getString("prenom"));
                entity.setNumTel(resultSet.getInt("numeroTel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public Personne getPersonneByNom(String nom) {
        Personne entity = null;
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Personne WHERE nom = ? ORDER BY NOM ASC");
            preparedStatement.setString(1, nom);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = new Personne();
                entity.setNom(resultSet.getString("nom"));
                entity.setPrenom(resultSet.getString("prenom"));
                entity.setNumTel(resultSet.getInt("numeroTel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void deletePersonneByNum(int num){
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Personne WHERE numeroTel = ?");
            preparedStatement.setInt(1, num);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Personne create(Personne obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Personne(nom, prenom, numeroTel) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, obj.getNom());
            preparedStatement.setString(2, obj.getPrenom());
            preparedStatement.setInt(3, obj.getNumTel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void delete(Personne obj) {
        // nous n'utilisons pas cette méthode pour notre suppression mais nous sommes obligés de la définir
    }

}