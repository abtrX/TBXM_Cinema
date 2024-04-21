package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import DAO.ConnexionBDD;

public class SuppUtilisateurModele {
    public void supprimerUtilisateur(String mail) {
        try (Connection connexion = ConnexionBDD.obtenirConnexion()) {
            // Préparation de la requête SQL pour supprimer l'utilisateur
            String sql = "DELETE FROM utilisateur WHERE Mail = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, mail);

            // Exécution de la requête
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Utilisateur supprimé avec succès !");
            } else {
                System.out.println("Aucun utilisateur n'a été supprimé.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
        }
    }

}
