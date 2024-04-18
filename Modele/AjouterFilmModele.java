package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjouterFilmModele {
    private Connection connexion;
    public static void ajouterFilm(String Nom, String Auteur) {
        try (Connection connexion = ConnexionBDD.obtenirConnexion()) {
            String sql = "INSERT INTO Film (Nom, Auteur) VALUES (?, ?)";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, Nom);
            statement.setString(2, Auteur);
            statement.executeUpdate();
            System.out.println("Film Ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'ajout du film " + e.getMessage());
        }
    }

}
