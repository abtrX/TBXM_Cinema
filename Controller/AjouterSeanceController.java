package Controller;

import Modele.AjouterSeanceModele;
import Modele.ListeFilms.Film;

public class AjouterSeanceController {
    private AjouterSeanceModele modele;

    public AjouterSeanceController() {
        modele = new AjouterSeanceModele();
    }

    public void ajouterSeance(Film film, int salle, String date, String heure) {
        // Appeler la méthode du modèle pour ajouter la séance
        modele.ajouterSeance(film, salle, date, heure);
    }
}
