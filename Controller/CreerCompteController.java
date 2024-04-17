package Controller;

import Modele.CreationCompteModele;
import View.ConnexionView;

import java.sql.Connection;

public class CreerCompteController {

    private Connection connexion;

    public static void creerCompte(String[] donneesUtilisateur, Connection connexion) {
        String Nom = donneesUtilisateur[0];
        String Mail = donneesUtilisateur[1];
        String MotDePasse = donneesUtilisateur[2];
        String Statut = donneesUtilisateur[3];
        CreationCompteModele.creerCompte(Nom, Mail, MotDePasse, Statut);
        ConnexionView connexionView = new ConnexionView(Statut, connexion);
        connexionView.setVisible(true);
    }
}
