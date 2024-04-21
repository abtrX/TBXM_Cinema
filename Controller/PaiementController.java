package Controller;

import DAO.PaiementDAO;
import Modele.InfoFilmModele;
import Modele.SeanceInfo;

import java.util.List;

public class PaiementController {
    private InfoFilmModele modele;

    public PaiementController(SeanceInfo disponibilite) {

        int filmId = disponibilite.getFilmId();
        this.modele = new InfoFilmModele(filmId);

    }

    // Méthode pour traiter le paiement avec la liste des disponibilités
    public void processPayment(SeanceInfo disponibilites, int nombreBillets) {
        // Parcourir la liste des disponibilités pour trouver la séance sélectionnée
        int seanceId = Integer.parseInt(disponibilites.getSeanceId());
        // Vérifier si la séance correspond à celle sélectionnée par l'utilisateur
        // Récupérer le nombre de places disponibles pour cette séance
        int placesDispo = disponibilites.getPlacesDispo();

        // Vérifier si le nombre de billets demandés est inférieur au nombre de places disponibles
        if (nombreBillets <= placesDispo) {
            // Effectuer le paiement
            System.out.println("Paiement effectué pour " + nombreBillets + " billets.");
            boolean paiementDAO = PaiementDAO.processPayment(seanceId, nombreBillets);

            // Utilisez la variable paiementDAO selon vos besoins
            if (paiementDAO) {
                System.out.println("Paiement effectué avec succès.");
            } else {
                System.out.println("Échec du paiement. Veuillez réessayer.");
            }
        } else {
            // Afficher un message d'erreur si le nombre de billets demandés dépasse le nombre de places disponibles
            System.out.println("Nombre de billets demandés supérieur aux places disponibles.");
        }


    }
}
