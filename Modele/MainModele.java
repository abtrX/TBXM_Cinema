package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainModele {
    // Connexion à la base de données
    Connection connexion = null;
    try {
        connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_cinema", "root");

        // Actualiser les différentes données
        GestionnaireUtilisateurs gestionnaireUtilisateurs = new GestionnaireUtilisateurs(connexion);
        gestionnaireUtilisateurs.actualiserNom(1, "Nouveau nom");
        gestionnaireUtilisateurs.actualiserMail(1, "nouveau@mail.com");
        gestionnaireUtilisateurs.actualiserMotDePasse(1, "nouveaumotdepasse");

        // Vous pouvez ajouter d'autres appels pour actualiser d'autres données

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Fermer la connexion
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
