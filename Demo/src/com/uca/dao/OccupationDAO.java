package src.com.uca.dao;

import src.com.uca.entity.Occupation;
import src.com.uca.entity.Personne;

import java.sql.*;
import java.util.ArrayList;

public class OccupationDAO extends _Generic<Occupation> {

    public ArrayList<Personne> getAllProprietaire(int numeroAppt, String adresseAppt) {
        ArrayList<Occupation> entities = new ArrayList<>();
        ArrayList<Personne> entities2 = new ArrayList<>();
        try {
            // on récupère tout les propriétaires de cet appartement
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Occupation WHERE statut = 'Propriétaire' AND numeroAppt = ? AND adresseAppt = ? ORDER BY numeroTel ASC;");
            preparedStatement.setInt(1, numeroAppt);
            preparedStatement.setString(2, adresseAppt);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Occupation entity = new Occupation(resultSet.getInt("numeroTel"), resultSet.getString("statut"), resultSet.getInt("numeroAppt"), resultSet.getString("adresseAppt"));
                entities.add(entity);
            }
            // pour chaque propriétaire on récupère grâce à son numéro, ses infos personnelles (car quand on clique sur un appartement, on ne veut pas juste afficher le numéro de téléphone qui est dans la table occupation mais également son nom et son prénom)
            for(int i = 0 ; i < entities.size() ; i++){
                PreparedStatement preparedStatement2 = this.connect.prepareStatement("SELECT * FROM Personne WHERE numeroTel = ?;");
                preparedStatement2.setInt(1, entities.get(i).getNumeroTel());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while(resultSet2.next()) {
                    Personne entity = new Personne(resultSet2.getString("nom"), resultSet2.getString("prenom"), resultSet2.getInt("numeroTel"));
                    entities2.add(entity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities2;
    }

    public ArrayList<Personne> getAllLocataire(int numeroAppt, String adresseAppt) {
        ArrayList<Occupation> entities = new ArrayList<>();
        ArrayList<Personne> entities2 = new ArrayList<>();
        try {
            // on récupère tout les locataires de cet appartement
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Occupation WHERE statut = 'Locataire' AND numeroAppt = ? AND adresseAppt = ? ORDER BY numeroTel ASC;");
            preparedStatement.setInt(1, numeroAppt);
            preparedStatement.setString(2, adresseAppt);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Occupation entity = new Occupation(resultSet.getInt("numeroTel"), resultSet.getString("statut"), resultSet.getInt("numeroAppt"), resultSet.getString("adresseAppt"));
                entities.add(entity);
            }
            // pour chaque locataire on récupère grâce à son numéro, ses infos personnelles (car quand on clique sur un appartement, on ne veut pas juste afficher le numéro de téléphone qui est dans la table occupation mais également son nom et son prénom)
            for(int i = 0 ; i < entities.size() ; i++){
                PreparedStatement preparedStatement2 = this.connect.prepareStatement("SELECT * FROM Personne WHERE numeroTel = ?;");
                preparedStatement2.setInt(1, entities.get(i).getNumeroTel());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while(resultSet2.next()) {
                    Personne entity = new Personne(resultSet2.getString("nom"), resultSet2.getString("prenom"), resultSet2.getInt("numeroTel"));
                    entities2.add(entity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities2;
    }

    @Override
    public Occupation create(Occupation obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Occupation (numeroTel, statut, numeroAppt, adresseAppt) VALUES (?, ?, ?, ?);");
            preparedStatement.setInt(1, obj.getNumeroTel());
            preparedStatement.setString(2, obj.getStatut());
            preparedStatement.setInt(3, obj.getNumeroAppt());
            preparedStatement.setString(4, obj.getAdresseAppt());
            preparedStatement.executeUpdate();

            preparedStatement = this.connect.prepareStatement("UPDATE appartement SET estLoue = 1 WHERE numero = ? AND adresse = ?");
            preparedStatement.setInt(1, obj.getNumeroAppt());
            preparedStatement.setString(2, obj.getAdresseAppt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Occupation obj) {
        try {
            PreparedStatement preparedStatement1 = this.connect.prepareStatement("DELETE FROM Occupation WHERE numeroTel = ?");
            preparedStatement1.setInt(1, obj.getNumeroTel());
            preparedStatement1.executeUpdate();

            Occupation entity = null;
            PreparedStatement preparedStatement2 = this.connect.prepareStatement("SELECT * FROM Occupation WHERE statut = 'Locataire' AND numeroAppt = ? AND adresseAppt = ?");
            preparedStatement2.setInt(1, obj.getNumeroAppt());
            preparedStatement2.setString(2, obj.getAdresseAppt());
            ResultSet resultSet = preparedStatement2.executeQuery();
            if (resultSet.next()) {
                entity = new Occupation(resultSet.getInt("numeroTel"), resultSet.getString("statut"), resultSet.getInt("numeroAppt"), resultSet.getString("adresseAppt"));
            }

            if(entity == null){
                PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE appartement SET estLoue = 0 WHERE numero = ? AND adresse = ?");
                preparedStatement.setInt(1, obj.getNumeroAppt());
                preparedStatement.setString(2, obj.getAdresseAppt());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}