package src.com.uca.dao;

import src.com.uca.entity.Syndicat;


import java.sql.*;
import java.util.ArrayList;

public class SyndicatDAO extends _Generic<Syndicat> {

    public SyndicatDAO(){
        //ignore
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
                entity.setMail(resultSet.getString("mail"));
                entity.setAdresse(resultSet.getString("adresse"));
                entity.setNumTel(resultSet.getInt("numTel"));
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