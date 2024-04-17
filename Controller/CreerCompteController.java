package Controller;

import Modele.CreationCompteModele;
import View.ConnexionView;

public class CreerCompteController {

    public static void creerCompte(String[] donneesUtilisateur) {
        String Nom = donneesUtilisateur[0];
        String Mail = donneesUtilisateur[1];
        String MotDePasse = donneesUtilisateur[2];
        String Statut = donneesUtilisateur[3];
        CreationCompteModele.creerCompte(Nom, Mail, MotDePasse, Statut);
        ConnexionView connexionView = new ConnexionView();
        connexionView.setVisible(true);
    }
}
