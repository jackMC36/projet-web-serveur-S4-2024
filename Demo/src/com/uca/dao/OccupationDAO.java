package src.com.uca.dao;

import src.com.uca.entity.Occupation;

import java.sql.*;
import java.util.ArrayList;

public class OccupationDAO extends _Generic<Occupation> {

    public Occupation getOccupationByNumero(int numero) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Occupation WHERE numTel = ? ORDER BY NOM ASC");
            preparedStatement.setInt(1, numero);
            ResultSet resultSet = preparedStatement.executeQuery();
            Occupation entity = new Occupation();
            entity.setNumero_appartement(resultSet.getInt("numero_appartement"));
            entity.setStatut(resultSet.getInt("statut"));
            entity.setNumTel(resultSet.getInt("numTel"));
            return entity;
            

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Occupation create(Occupation obj) {
        //TODO !
        return null;
    }

    @Override
    public void delete(Occupation obj) {
        //TODO !
    }
}