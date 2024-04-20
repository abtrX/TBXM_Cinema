package Modele;

import DAO.ConnexionBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InfoFilmModele {
    private int filmId;
    private Connection connection;

    public InfoFilmModele(int filmId) {
        this.filmId = filmId;
    }

    public List<String> getDisponibilites() {
        List<String> disponibilites = new ArrayList<>();
        try (Connection connexion = ConnexionBDD.obtenirConnexion()) {
            String sql = "SELECT SéanceId, NumeroSalle, Date, Heure FROM séance WHERE FilmId = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setInt(1, filmId); // Définition du paramètre FilmId
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String NumSalle = resultSet.getString("NumeroSalle");
                String date = resultSet.getString("Date");
                String séanceId = resultSet.getString("SéanceId");

                String heure = resultSet.getString("Heure");
                disponibilites.add("Numéro de Séance : "+ séanceId +" le "+ date + " à " + heure+" salle "+NumSalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération des disponibilités : " + e.getMessage());
        }
        return disponibilites;
    }
}
