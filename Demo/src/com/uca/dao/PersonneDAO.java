package src.com.uca.dao;

import src.com.uca.entity.Personne;

import java.sql.*;
import java.util.ArrayList;

public class PersonneDAO extends _Generic<Personne> {

    public Personne getPersonneByNumero(int numero) {
        Personne entity = null;
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Personne WHERE numTel = ? ORDER BY NOM ASC");
            preparedStatement.setInt(1, numero);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = new Personne();
                entity.setNom(resultSet.getString("nom"));
                entity.setNumTel(resultSet.getInt("numTel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Personne create(Personne obj) {
        //TODO !
        return null;
    }

    @Override
    public void delete(Personne obj) {
        //TODO !
    }

}