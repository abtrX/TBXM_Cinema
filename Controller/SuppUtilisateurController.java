package Controller;

import Modele.SuppUtilisateurModele;

public class SuppUtilisateurController {
    public void supprimerUtilisateur(String  mail) {
        // Appeler la méthode du modèle pour supprimer l'utilisateur
        SuppUtilisateurModele utilisateurSupp = new SuppUtilisateurModele();
        utilisateurSupp.supprimerUtilisateur(mail);
    }
}
