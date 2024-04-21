package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupprimerFilmDAO {
    public void supprimerFilm(int idFilm) throws SQLException {
        Connection connexion = null;
        try {
            connexion = ConnexionBDD.obtenirConnexion();
            String query = "DELETE FROM film WHERE FilmId = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, idFilm);
            statement.executeUpdate();
        } finally {
            if (connexion != null) {
                connexion.close();
            }
        }
    }
}