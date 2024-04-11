import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.uca._Connector;

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

            // Insert into Immeuble table
            statement = connection.prepareStatement("INSERT INTO Immeuble (nom, adresse, numero) VALUES (?, ?, ?);");
            statement.setString(1, "Immeuble A");
            statement.setString(2, "123 Main St");
            statement.setInt(3, 1);
            statement.executeUpdate();


            // Insert into Appartement table
            statement = connection.prepareStatement("INSERT INTO Appartement (etage, numero, superficie, estLoue, adresse) VALUES (?, ?, ?, ?, ?);");
            statement.setInt(1, 2);
            statement.setInt(2, 101);
            statement.setFloat(3, 75.5f);
            statement.setBoolean(4, false);
            statement.setString(5, "123 Main St");
            statement.executeUpdate();

            // Insert into Syndicat table
            statement = connection.prepareStatement("INSERT INTO Syndicat (nom, adresse, nom_referent, numero, adresse_mail) VALUES (?, ?, ?, ?, ?);");
            statement.setString(1, "Syndicat A");
            statement.setString(2, "123 Main St");
            statement.setString(3, "John Doe");
            statement.setInt(4, 1);
            statement.setString(5, "syndicatA@example.com");
            statement.executeUpdate();

            // Insert into Personne table
            statement = connection.prepareStatement("INSERT INTO Personne (nom, prenom, numero) VALUES (?, ?, ?);");
            statement.setString(1, "Doe");
            statement.setString(2, "Jane");
            statement.setInt(3, 1);
            statement.executeUpdate();
        } 
        catch(Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
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
            immeuble.setNumero(resultSet.getInt("numero"));
            immeubles.add(immeuble);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return immeubles;
}
}
