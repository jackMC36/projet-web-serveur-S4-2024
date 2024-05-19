package src.com.uca.dao;

import java.sql.*;
import java.util.ArrayList;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;


import src.com.uca.entity.Compte;

public class CompteDAO extends _Generic<Compte> {

    public Compte create(Compte obj) {
        try {
            if (numeroValide(obj.getNum_tel())) {
                return null;
            }
            if(!formatNumeroValide(Integer.toString(obj.getNum_tel()))){
                return null;
            }
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Compte(num_tel, mdp) VALUES (?, ?);");
            preparedStatement.setInt(1, obj.getNum_tel());
            preparedStatement.setString(2, hashPassword(obj.getMdp()));
            preparedStatement.executeUpdate();
            return obj;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(Compte obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Compte WHERE num_tel = ?;");
            preparedStatement.setInt(1, obj.getNum_tel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCompteByNumTel(int num_tel) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Compte WHERE num_tel = ?;");
            preparedStatement.setInt(1, num_tel);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, hash);
            StringBuilder hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkPassword(String providedPassword, String storedPasswordHash) {
        String hashedProvidedPassword = hashPassword(providedPassword);
        return hashedProvidedPassword.equals(storedPasswordHash);
    }

    public boolean numeroValide(int num_tel) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Compte WHERE num_tel = ?;");
            preparedStatement.setInt(1, num_tel);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean formatNumeroValide(String num_tel) {
        return num_tel.matches("[0-9]{8}");
    }

    public String loginCompte(int num_tel, String mdp) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Compte WHERE num_tel = ?;");
            preparedStatement.setInt(1, num_tel);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (checkPassword(mdp, resultSet.getString("mdp"))) {
                    System.out.println("Connexion réussie");
                    return "Success";
                } else {
                    System.out.println("Mot de passe incorrect");
                    return "MDPFalse";
                }
            } else {
                System.out.println("Numéro de téléphone non enregistré");
                return "NumberNotInDB";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public boolean checkNumberInDB(int num_tel) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM Compte WHERE num_tel = ?;");
            preparedStatement.setInt(1, num_tel);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}

