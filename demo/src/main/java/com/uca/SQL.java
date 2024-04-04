import java.sql.*;

public class SQL{
    public static void Init(){
        Connection connection = _Connector.getInstance();
        try{
            PreparedStatement statement;

            //Init table
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Immeuble (nom VARCHAR(30), adresse VARCHAR(40) PRIMARY KEY, numero INT, FOREIGN KEY (numero) REFERENCES Syndicat(numero));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Appartement (etage INT, numero INT, superficie FLOAT, estLoue BOOLEAN, adresse VARCHAR(40), PRIMARY KEY (numero, adresse), FOREIGN KEY (adresse) REFERENCES Immeuble(adresse));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Syndicat (nom VARCHAR(20), adresse VARCHAR(40), nom_referent VARCHAR(20), numero INT, adresse_mail VARCHAR(30), PRIMARY KEY (nom, adresse));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Personne (nom VARCHAR(30), prenom VARCHAR(30), numero INT PRIMARY KEY);");
            statement.executeUpdate();

            /*Todo Remove me !
            statement = connection.prepareStatement("INSERT INTO users(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, "Theodore");
            statement.setString(2, "Muillerez");
            statement.executeUpdate();*/
        } 
        catch(Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
