package src.com.uca.dao;

import java.sql.*;
import src.com.uca.dao._Connector;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {

            PreparedStatement statementPersonne = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Personne ( nom VARCHAR(30), prenom VARCHAR(30), numero INT PRIMARY KEY);");
            statementPersonne.executeUpdate();

            PreparedStatement statementSyndicat = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Syndicat( nom VARCHAR(20), adresse VARCHAR(40), numero INT UNIQUE,  adresse_mail VARCHAR(30), nom_referent VARCHAR(20), PRIMARY KEY (nom, adresse));");
            statementSyndicat.executeUpdate();

            PreparedStatement statementImmeuble = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Immeuble (nom VARCHAR(30), adresse VARCHAR(40) PRIMARY KEY, numero INT, nom_syndicat VARCHAR(20), adresse_syndicat VARCHAR(40), FOREIGN KEY (numero, nom_syndicat, adresse_syndicat) REFERENCES Syndicat(numero, nom, adresse));");
            statementImmeuble.executeUpdate();

            PreparedStatement statementAppartement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Appartement (etage INT, numero INT, superficie FLOAT, estLoue BOOLEAN, adresse VARCHAR(40), FOREIGN KEY (adresse) REFERENCES Immeuble(adresse), PRIMARY KEY (numero,adresse));");
            statementAppartement.executeUpdate();

            PreparedStatement StatementOccupation = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Occupation (numero INT, statut INT, appartement_numero INT, adresse VARCHAR(40), FOREIGN KEY (numero) REFERENCES Personne(numero), FOREIGN KEY (adresse) REFERENCES Appartement(adresse), FOREIGN KEY (appartement_numero) REFERENCES Appartement(numero));");
            StatementOccupation.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}