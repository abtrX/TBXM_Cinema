package Controller;

import Modele.AjouterFilmModele;
import Modele.CreationCompteModele;
import View.AjouterFilmView;
import View.ConnexionView;
import View.PageAccueil;

import java.math.BigDecimal;
import java.sql.Connection;

public class AjouterFilmController {
    private static AjouterFilmView view;
    private static AjouterFilmModele modele;

    public static void ajouterFilm(String Nom, String Auteur, String statutUtilisateur) {
        AjouterFilmModele.ajouterFilm(Nom, Auteur);
        PageAccueil pageAccueil=new PageAccueil(statutUtilisateur);
        pageAccueil.setVisible(true);
    }


}
