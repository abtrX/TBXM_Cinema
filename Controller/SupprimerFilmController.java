package Controller;

import Modele.SupprimerFilmModele;
import View.PageAccueil;

import java.sql.SQLException;

public class SupprimerFilmController {
    private SupprimerFilmModele modele;

    public SupprimerFilmController() {
        this.modele = new SupprimerFilmModele();
    }

    public void supprimerFilm(int idFilm) {
        try {
            modele.supprimerFilm(idFilm); // Appel de la méthode supprimerFilm du modèle
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur de suppression du film
        }
    }
}