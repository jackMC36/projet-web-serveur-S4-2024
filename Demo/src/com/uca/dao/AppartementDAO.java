package src.com.uca.dao;

import src.com.uca.entity.Appartement;
import src.com.uca.entity.Syndicat;

import java.sql.*;
import java.util.ArrayList;

public class AppartementDAO extends _Generic<Appartement> {

    public ArrayList<Appartement> getAllAppartementsByAdresse(String adresse) {
        ArrayList<Appartement> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Appartement ORDER BY NOM ASC WHERE adresse =  " + adresse + ";");
            ResultSet resultSet = preparedStatement.executeQuery();
            Appartement entity = new Appartement();
            entity.setEtage(resultSet.getInt("etage"));
            entity.setNumero(resultSet.getInt("numero"));
            entity.setAdresse(adresse);
            entity.setSuperficie(resultSet.getFloat("superficie"));
            entity.setEstLoue(resultSet.getBoolean("estLoue"));
            entities.add(entity);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public Appartement create(Appartement obj) {
        //TODO !
        return null;
    }

    @Override
    public void delete(Appartement obj) {
        //TODO !
    }

}