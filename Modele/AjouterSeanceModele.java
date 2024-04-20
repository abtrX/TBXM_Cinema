package Modele;

import DAO.ConnexionBDD;
import Modele.ListeFilms.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjouterSeanceModele {

    public void ajouterSeance(Film film, int salle, String date, String heure) {
        try (Connection connexion = ConnexionBDD.obtenirConnexion()) {
            // Préparation de la requête SQL pour insérer une nouvelle séance dans la base de données
            String sql = "INSERT INTO Séance (FilmId, NumeroSalle, Date, Heure, Prix) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setInt(1, film.getFilmId()); // ID du film
            statement.setInt(2, salle); // salle de la séance
            statement.setString(3, date); // Date de la séance
            statement.setString(4, heure); // Heure de la séance
            statement.setDouble(5, 10); // Prix de la séance 10 par défaut

            // Exécution de la requête
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("La séance a été ajoutée avec succès !");
            } else {
                System.out.println("Erreur lors de l'ajout de la séance.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'ajout de la séance : " + e.getMessage());
        }
    }

}
