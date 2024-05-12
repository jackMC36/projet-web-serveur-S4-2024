package src.com.uca.dao;

import src.com.uca.entity.Appartement;
import src.com.uca.entity.Syndicat;

import java.sql.*;
import java.util.ArrayList;

public class AppartementDAO extends _Generic<Appartement> {

    public ArrayList<Appartement> getAllAppartementsByAdresse(String adresse) {
        ArrayList<Appartement> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Appartement WHERE adresse = ? ORDER BY etage, numero ASC;");
            preparedStatement.setString(1, adresse);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Appartement entity = new Appartement(resultSet.getInt("etage"), resultSet.getInt("numero"), resultSet.getFloat("superficie"), resultSet.getString("adresse"), resultSet.getInt("estLoue"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public void deleteAppartement(int numero, String adresse) {
        try {
            PreparedStatement preparedStatement1 = this.connect.prepareStatement("DELETE FROM appartement WHERE numero = ? AND adresse = ?;");
            preparedStatement1.setInt(1, numero);
            preparedStatement1.setString(2, adresse);
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Appartement create(Appartement obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Appartement(etage, numero, superficie, estLoue, adresse) VALUES (?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, obj.getEtage());
            preparedStatement.setInt(2, obj.getNumero());
            preparedStatement.setFloat(3, obj.getSuperficie());
            preparedStatement.setInt(4, obj.getEstLoue());
            preparedStatement.setString(5, obj.getAdresse());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Appartement obj) {
        // nous n'utilisons pas cette méthode pour notre suppression mais nous sommes obligés de la définir
    }

}