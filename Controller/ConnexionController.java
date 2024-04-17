package Controller;

import Modele.ConnexionModele;
import View.ConnexionView;
import View.PageAccueil;
import java.sql.Connection;

public class ConnexionController {
    private Connection connexion;

    public static void connecter(String[] informationsConnexion, String statutUtilisateur, Connection connexion) {
    statutUtilisateur = ConnexionModele.connecter(informationsConnexion);
    while (statutUtilisateur == null) {
        ConnexionView connexionView = new ConnexionView(statutUtilisateur, connexion);
        connexionView.setVisible(true);
        //print un message d'erreur invitant à l'utilisateur à recommencer
    }
    // Si les informations de connexion sont valides, ouvrir la page appropriée
    PageAccueil pageAccueil = new PageAccueil(connexion, statutUtilisateur);
    pageAccueil.setVisible(true);
    }
}

