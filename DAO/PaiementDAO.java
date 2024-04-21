package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaiementDAO {
    // Méthode pour effectuer le paiement et mettre à jour le nombre de places disponibles
    public static boolean processPayment(int seanceId, int nombreBillets) {
        // Connexion à la base de données
        try (Connection connexion = ConnexionBDD.obtenirConnexion()) {
            String sql = "UPDATE séance SET placesdispo = placesdispo - ? WHERE SéanceId = ? AND placesdispo >= ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setInt(1, nombreBillets); // Nombre de billets achetés
            statement.setInt(2, seanceId); // Identifiant de la séance
            statement.setInt(3, nombreBillets); // Vérification du nombre de places disponibles

            // Exécuter la mise à jour
            int rowsUpdated = statement.executeUpdate();

            // Si au moins une ligne a été mise à jour, le paiement a été effectué avec succès
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
