package Controller;

import Modele.ListeFilms;
import View.InfoFilm;

public class RechercherController {
    private String searchTerm;
    private String stautUtilisateur;
    private Modele.ListeFilms.Film film;
    public void rechercher(Modele.ListeFilms.Film film) {
        InfoFilm infosFilm = new InfoFilm();
        infosFilm.infoFilmView(film,stautUtilisateur);
    }
}
