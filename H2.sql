CREATE DATABASE H2;

USE H2;

CREATE TABLE Immeuble (
    nom VARCHAR(30),
    adresse VARCHAR(40) PRIMARY KEY,
    numero INT,
    FOREIGN KEY (numero) REFERENCES Syndicat(numero)
);

CREATE TABLE Appartement (
    etage INT,
    numero INT,
    superficie FLOAT,
    estLoue BOOLEAN,
    adresse VARCHAR(40),
    FOREIGN KEY (adresse) REFERENCES Immeuble(adresse),
    PRIMARY KEY (numero,adresse)
);

CREATE TABLE Syndicat(
    nom VARCHAR(20),
    adresse VARCHAR(40),
    adresse_mail VARCHAR(30),
    nom_referent VARCHAR(20),
    PRIMARY KEY (nom, adresse)
);

CREATE TABLE Personne (
    nom VARCHAR(30),
    prenom VARCHAR(30),
    numero INT PRIMARY KEY
);

CREATE TABLE Occupation(
    numero INT,
    statut INT,
    appartement_numero INT,
    adresse VARCHAR(40),
    FOREIGN KEY (numero) REFERENCES Personne(numero),
    FOREIGN KEY (adresse) REFERENCES Appartement(adresse),
    FOREIGN KEY (appartement_numero) REFERENCES Appartement(numero)
);