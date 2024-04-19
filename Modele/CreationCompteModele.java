package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.ConnexionBDD;

public class CreationCompteModele {
    //commentaires
    public static void creerCompte(String Nom, String Mail, String MotDePasse, String Statut) {
        try (Connection connexion = ConnexionBDD.obtenirConnexion()) {
            String sql = "INSERT INTO utilisateur (Nom, Mail, MotDePasse, Statut) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, Nom);
            statement.setString(2, Mail);
            statement.setString(3, MotDePasse);
            statement.setString(4, Statut);
            statement.executeUpdate();
            System.out.println("Compte créé avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la création du compte : " + e.getMessage());
        }
    }
}
