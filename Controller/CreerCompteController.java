package Controller;

import Modele.CreationCompteModele;

public class CreerCompteController {

    public static void creerCompte(String[] donneesUtilisateur) {
        String Nom = donneesUtilisateur[0];
        String Mail = donneesUtilisateur[1];
        String MotDePasse = donneesUtilisateur[2];
        String Statut = donneesUtilisateur[3];
        CreationCompteModele.creerCompte(Nom, Mail, MotDePasse, Statut);
        // Redirection vers la page de connexion ou autre traitement nécessaire
        System.out.println("Page Connexion");
    }
}
