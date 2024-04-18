package Controller;

import Modele.AjouterFilmModele;
import Modele.CreationCompteModele;
import View.AjouterFilmView;
import View.ConnexionView;

import java.math.BigDecimal;
import java.sql.Connection;

public class AjouterFilmController {
    private static AjouterFilmView View;
    private static AjouterFilmModele Modele;

    public static void ajouterFilm(String Nom, String Auteur, String statutUtilisateur) {
        AjouterFilmModele.ajouterFilm(Nom, Auteur);
        ConnexionView connexionView = new ConnexionView(statutUtilisateur);
        connexionView.setVisible(true);
    }


}
