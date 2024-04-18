package Controller;

import Modele.CreationCompteModele;
import View.ConnexionView;

public class CreerCompteController {

    // Votre autre code ici

    public static void redirigerVersConnexion() {
        ConnexionView connexionView = new ConnexionView();
        connexionView.setVisible(true);
    }

    public static void creerCompte(String[] donneesUtilisateur) {
        String nom = donneesUtilisateur[0];
        String mail = donneesUtilisateur[1];
        String motDePasse = donneesUtilisateur[2];
        String statut = donneesUtilisateur[3];

        // Envoyer les données au modèle pour créer le compte
        CreationCompteModele.creerCompte(nom, mail, motDePasse, statut);

        // Rediriger vers la page de connexion après avoir créé le compte
        redirigerVersConnexion();
    }
}

