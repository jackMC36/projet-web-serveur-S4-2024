package src.com.uca.dao;

import java.sql.*;
import src.com.uca.dao._Connector;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {

            PreparedStatement statement;

            /* INITIALISATION          
            statement = connection.prepareStatement("DROP TABLE IF EXISTS Occupation;");
            statement.executeUpdate();
            
            statement = connection.prepareStatement("DROP TABLE IF EXISTS Appartement;");
            statement.executeUpdate();

            statement = connection.prepareStatement("DROP TABLE IF EXISTS Immeuble;");
            statement.executeUpdate();

            statement = connection.prepareStatement("DROP TABLE IF EXISTS Syndicat;");
            statement.executeUpdate();

            statement = connection.prepareStatement("DROP TABLE IF EXISTS Personne;");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Personne (nom VARCHAR(30), prenom VARCHAR(30), numeroTel INT PRIMARY KEY);");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Syndicat (nom VARCHAR(25), adresse VARCHAR(50), nom_referent VARCHAR(25), numeroTel INT, adresse_mail VARCHAR(30), PRIMARY KEY (nom,adresse), FOREIGN KEY (nom_referent, numeroTel) REFERENCES Personne(nom, numeroTel));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Immeuble (nom VARCHAR(40), adresse VARCHAR(50) PRIMARY KEY, syndicat VARCHAR(25), FOREIGN KEY (syndicat) REFERENCES Syndicat(nom));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Appartement (etage INT, numero INT, superficie INT, estLoue INT, adresse VARCHAR(40), PRIMARY KEY (numero, adresse), FOREIGN KEY (adresse) REFERENCES Immeuble(adresse));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Occupation (numero INT, statut INT, appartement_numero INT, adresse VARCHAR(40), FOREIGN KEY (numero) REFERENCES Personne(numeroTel), FOREIGN KEY (adresse) REFERENCES Appartement(adresse), FOREIGN KEY (appartement_numero) REFERENCES Appartement(numero));");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Personne (nom, prenom, numeroTel) VALUES ('Dupont', 'Jean', 0601020304);");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Personne (nom, prenom, numeroTel) VALUES ('Durand', 'Pierre', 0601020305);");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Syndicat (nom, adresse, nom_referent, numeroTel, adresse_mail) VALUES ('Syndicat A', '1 rue de la paix' , 'Dupont', 0601020304, 'dupont@uca.fr');");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Immeuble (nom, adresse, syndicat) VALUES ('Immeuble A', '1 rue de la paix', 'Syndicat A');");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Appartement (etage, numero, superficie, estLoue, adresse) VALUES (1, 1, 50, 0, '1 rue de la paix');");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Appartement (etage, numero, superficie, estLoue, adresse) VALUES (2, 21, 50, 0, '1 rue de la paix');");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Appartement (etage, numero, superficie, estLoue, adresse) VALUES (6, 64, 50, 0, '1 rue de la paix');");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Appartement (etage, numero, superficie, estLoue, adresse) VALUES (5, 52, 50, 1, '1 rue de la paix');");
            statement.executeUpdate();
            */

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }

    /*public List<Immeuble> getAllImmeubles() {
        List<Immeuble> immeubles = new ArrayList<>();
        Connection connection = _Connector.getInstance();
        try {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Immeuble");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Immeuble immeuble = new Immeuble();
            immeuble.setNom(resultSet.getString("nom"));
            immeuble.setAdresse(resultSet.getString("adresse"));
            immeubles.add(immeuble);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return immeubles;
        }
    */
}