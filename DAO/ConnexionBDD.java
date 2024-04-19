package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import View.PageAccueil;

public class ConnexionBDD {
    private static final String URL = "jdbc:mysql://localhost:3306/bdd_cinema";
    private static final String UTILISATEUR = "root";

    public static Connection obtenirConnexion() throws SQLException {
        //String motDePasse = "useruser"; // Remplacez "votre_mot_de_passe" par le mot de passe de l'utilisateur 'root'
        Properties properties = new Properties();
        properties.setProperty("user", UTILISATEUR);
        //properties.setProperty("password", motDePasse); // Spécifiez le mot de passe

        return DriverManager.getConnection(URL, properties);
    }


    public static void fermerConnexion(Connection connexion) {
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Connection connexion = obtenirConnexion();
            String statutUtilisateur = null;
            // Appeler la page d'accueil en lui passant la connexion
            PageAccueil pageAccueil = new PageAccueil(statutUtilisateur);
            pageAccueil.setVisible(true);
            // Fermeture de la connexion à la base de données
            fermerConnexion(connexion);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}
