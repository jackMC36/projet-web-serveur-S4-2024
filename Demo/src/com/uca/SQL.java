package src.com.uca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.com.uca._Connector;
import src.com.uca.entity.Immeuble;


public class SQL{
    public static void Init(){
        Connection connection = _Connector.getInstance();
        try{
            PreparedStatement statement;

            //Init table
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Personne (nom VARCHAR(30), prenom VARCHAR(30), numeroTel VARCHAR(30) PRIMARY KEY);");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Syndicat (nom VARCHAR(25), adresse VARCHAR(50), nom_referent VARCHAR(25), numeroTel VARCHAR(30), adresse_mail VARCHAR(30), PRIMARY KEY (nom,adresse), FOREIGN KEY (nom_referent, numeroTel) REFERENCES Personne(nom, numeroTel));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Immeuble (nom VARCHAR(40), adresse VARCHAR(50) PRIMARY KEY, syndicat VARCHAR(25), FOREIGN KEY (syndicat) REFERENCES Syndicat(nom));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Appartement (etage INT, numero INT, superficie INT, estLoue BOOLEAN, adresse VARCHAR(40), PRIMARY KEY (numero, adresse), FOREIGN KEY (adresse) REFERENCES Immeuble(adresse));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Occupation (numero INT, statut INT, appartement_numero INT, adresse VARCHAR(40), FOREIGN KEY (numero) REFERENCES Personne(numero), FOREIGN KEY (adresse) REFERENCES Appartement(adresse), FOREIGN KEY (appartement_numero) REFERENCES Appartement(numero));");
            statement.executeUpdate();

            //Insertion de données
            statement = connection.prepareStatement("INSERT INTO Personne (nom, prenom, numeroTel) VALUES ('Dupont', 'Jean', '0601020304');");
            statement.executeUpdate();
            statement = connection.prepareStatement("INSERT INTO Personne (nom, prenom, numeroTel) VALUES ('Durand', 'Pierre', '0601020305');");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Syndicat (nom, adresse, nom_referent, numeroTel, adresse_mail) VALUES ('Syndicat A', '1 rue de la paix' , 'Dupont', 'dupont@uca.fr' ,  '0601020304');");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Immeuble (nom, adresse, syndicat) VALUES ('Immeuble A', '1 rue de la paix', 'Syndicat A');");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO Appartement (etage, numero, superficie, estLoue, adresse) VALUES (1, 1, 50, false, '1 rue de la paix');");
            statement.executeUpdate();
            

            
        } 
        catch(Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("ERREUR: impossible de créer la base !");
        }
    }

    public List<Immeuble> getAllImmeubles() {
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
}
