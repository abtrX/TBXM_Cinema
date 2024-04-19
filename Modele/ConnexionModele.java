package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.ConnexionBDD;

public class ConnexionModele {

    public static String connecter(String[] informationsConnexion) {
        String mail = informationsConnexion[0];
        String motDePasse = informationsConnexion[1];
        try (Connection connexion = ConnexionBDD.obtenirConnexion()) {
            String sql = "SELECT Statut FROM utilisateur WHERE Mail = ? AND MotDePasse = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, mail);
            statement.setString(2, motDePasse);
            ResultSet resultSet = statement.executeQuery();

            // Si une ligne est retournée, cela signifie que les informations de connexion sont valides
            // On récupère le statut de l'utilisateur et on le retourne
            if (resultSet.next()) {
                return resultSet.getString("Statut");
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // En cas d'erreur, la connexion échoue
        }
    }
}
