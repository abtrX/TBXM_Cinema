package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnexionBDD {
    private static final String URL = "jdbc:mysql://localhost:3306/bdd_cinema";
    private static final String UTILISATEUR = "root";

    public static Connection obtenirConnexion() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", UTILISATEUR);

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
            // Obtention de la connexion à la base de données
            Connection connexion = obtenirConnexion();

            // Appeler votre vue de connexion
            ConnexionView connexionView = new ConnexionView();
            connexionView.setVisible(true);
            String[] informationsConnexion = connexionView.saisirInformationsConnexion();

            ConnexionController.connecter(informationsConnexion);

            // Fermeture de la connexion à la base de données
            fermerConnexion(connexion);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}
