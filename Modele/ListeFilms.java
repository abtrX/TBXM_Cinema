package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ConnexionBDD;

public class ListeFilms {

    public static List<Film> getFilms() {
        List<Film> films = new ArrayList<>();
        Connection connexion = null;
        try {
            connexion = ConnexionBDD.obtenirConnexion();
            // Use the connection object
        } catch (SQLException e) {
            // Handle the SQLException
            e.printStackTrace(); // Or handle it in another appropriate way
        }
        try {
            String sql = "SELECT * FROM film";
            PreparedStatement statement = connexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Pour chaque ligne de résultat, créer un objet Film et l'ajouter à la liste
                Film film = new Film(resultSet.getInt("FilmId"), resultSet.getString("Nom"), resultSet.getString("Auteur"));
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }

    // Classe interne pour représenter un film
    public static class Film {
        private int FilmId;
        private String Nom;
        private String Auteur;

        public Film(int FilmId, String Nom, String Auteur) {
            this.FilmId = FilmId;
            this.Nom = Nom;
            this.Auteur = Auteur;
        }

        public int getFilmId() {
            return FilmId;
        }

        public String getNom() {
            return Nom;
        }

        public String getAuteur() {
            return Auteur;
        }
    }
}
