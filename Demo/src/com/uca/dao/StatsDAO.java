package src.com.uca.dao;

import src.com.uca.entity.Occupation;

import java.sql.*;
import java.util.ArrayList;


public class StatsDAO {

    public Connection connect = _Connector.getInstance();

    public ArrayList<Integer> getLogementLoue(int numeroTel) {
        ArrayList<Occupation> entities = new ArrayList<>();
        ArrayList<Integer> logement = new ArrayList<Integer>();
        int nbLoue = 0;
        int pourcentageLoue = 0;
        int nbVide = 0;
        int pourcentageVide = 0;
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM occupation WHERE numeroTel = ? AND statut = 'Propriétaire';");
            preparedStatement.setInt(1, numeroTel);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Occupation entity = new Occupation(resultSet.getInt("numeroTel"), resultSet.getString("statut"), resultSet.getInt("numeroAppt"), resultSet.getString("adresseAppt"));
                entities.add(entity);
            }

            for(int i = 0 ; i < entities.size() ; i++){
                PreparedStatement preparedStatement2 = this.connect.prepareStatement("SELECT estLoue FROM appartement WHERE numero = ? AND adresse = ?;");
                preparedStatement2.setInt(1, entities.get(i).getNumeroAppt());
                preparedStatement2.setString(2, entities.get(i).getAdresseAppt());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                if(resultSet2.next()){
                    if(resultSet2.getInt("estLoue") == 1){
                        nbLoue += 1;
                    }
                    else{
                        nbVide += 1;
                    }
                }
            }

            pourcentageLoue = (int) ((double) nbLoue / entities.size() * 100);
            pourcentageVide = (int) ((double) nbVide / entities.size() * 100);
            
            logement.add(entities.size());
            logement.add(pourcentageLoue);
            logement.add(pourcentageVide);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logement;
    }
}