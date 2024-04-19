package Controller;

import javax.swing.*;

import Modele.AjouterFilmModele;
import View.AjouterFilmView;
import View.PageAccueil;

public class AjouterFilmController {
    private static AjouterFilmView View;
    private static AjouterFilmModele Modele;

    public static void ajouterFilm(String Nom, String Auteur, String statutUtilisateur) {
        Modele = new AjouterFilmModele(); // Création de l'instance de AjouterFilmModele
        Modele.ajouterFilm(Nom, Auteur); // Appel de la méthode ajouterFilm du modèle
        PageAccueil pageAccueil = new PageAccueil(statutUtilisateur);
        View.dispose(); // Fermeture de la fenêtre AjouterFilmView
        pageAccueil.setVisible(true);
    }
}
