package src.com.uca.dao;

import src.com.uca.entity.Immeuble;

import java.sql.*;
import java.util.ArrayList;

import src.com.uca.entity.Immeuble;

public class ImmeubleDAO extends _Generic<Immeuble> {

    public ArrayList<Immeuble> getAllUsers() {
        ArrayList<Immeuble> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Immeuble ORDER BY NOM ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Immeuble entity = new Immeuble();
                entity.setNom(resultSet.getString("nom"));
                entity.setNumero(resultSet.getInt("numero"));
                entity.setAdresse(resultSet.getString("adresse"));

                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public Immeuble create(Immeuble obj) {
        //TODO !
        return null;
    }

    @Override
    public void delete(Immeuble obj) {
        //TODO !
    }
}
