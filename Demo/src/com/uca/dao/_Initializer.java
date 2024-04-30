package src.com.uca.dao;

import java.sql.*;
import src.com.uca.dao._Connector;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {

            PreparedStatement statement;

            //Init table



            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Personne (nom VARCHAR(30), prenom VARCHAR(30), numeroTel INT PRIMARY KEY);");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Syndicat (nom VARCHAR(25), adresse VARCHAR(50), nom_referent VARCHAR(25), numeroTel INT, adresse_mail VARCHAR(30), PRIMARY KEY (nom,adresse), FOREIGN KEY (nom_referent, numeroTel) REFERENCES Personne(nom, numeroTel));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Immeuble (nom VARCHAR(40), adresse VARCHAR(50) PRIMARY KEY, syndicat VARCHAR(25), FOREIGN KEY (syndicat) REFERENCES Syndicat(nom));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Appartement (etage INT, numero INT, superficie INT, estLoue BOOLEAN, adresse VARCHAR(40), PRIMARY KEY (numero, adresse), FOREIGN KEY (adresse) REFERENCES Immeuble(adresse));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Occupation (numero INT, statut INT, appartement_numero INT, adresse VARCHAR(40), FOREIGN KEY (numero) REFERENCES Personne(numero), FOREIGN KEY (adresse) REFERENCES Appartement(adresse), FOREIGN KEY (appartement_numero) REFERENCES Appartement(numero));");
            statement.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}