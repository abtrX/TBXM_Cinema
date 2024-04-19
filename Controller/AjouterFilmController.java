package Controller;

import Modele.AjouterFilmModele;
import Modele.CreationCompteModele;
import View.AjouterFilmView;
import View.PageAccueil;

public class AjouterFilmController {
    private static AjouterFilmView View;
    private static AjouterFilmModele Modele;

    public static void ajouterFilm(String Nom, String Auteur, String statutUtilisateur) {
        AjouterFilmModele.ajouterFilm(Nom, Auteur);
        PageAccueil pageAccueil = new PageAccueil(statutUtilisateur);
        pageAccueil.setVisible(true);
    }


}
