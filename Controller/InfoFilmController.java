package Controller;

import Modele.InfoFilmModele;
import Modele.ListeFilms;
import View.InfoFilm;
import View.AjouterSeanceView;

public class InfoFilmController {
    private static InfoFilmModele modele;
    private static InfoFilm vue;




    public  InfoFilmController(int filmId) {
        modele = new InfoFilmModele(filmId);
        vue = new InfoFilm();
    }

    // Méthode pour obtenir les disponibilités à partir du modèle
    public String[] getDisponibilites() {
        return modele.getDisponibilites().toArray(new String[0]);
    }




    // Méthode pour mettre à jour les disponibilités si nécessaire
    /*
    public void updateDisponibilites() {
        modele.updateDisponibilites();
    }*/
}
