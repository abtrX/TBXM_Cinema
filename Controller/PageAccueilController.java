package Controller;

import Modele.ListeFilms;
import View.AjouterFilmView;
import View.ConnexionView;
import View.CreationCompteView;
import View.InfoFilm;

import java.util.List;

public class PageAccueilController {
    private String searchTerm;
    private String buttonPressed;
    private String statutUtilisateur;
    private Modele.ListeFilms.Film film; // Attribut de type Film

    // Ajoutez une liste de films en tant qu'argument au constructeur si nécessaire
    public PageAccueilController(String searchTerm, String buttonPressed, String statutUtilisateur, Modele.ListeFilms.Film film) {
        this.searchTerm = searchTerm;
        this.buttonPressed = buttonPressed;
        this.statutUtilisateur = statutUtilisateur;
        this.film = film; // Initialisation de l'attribut
    }

    public void onAction(List<ListeFilms.Film> films) {
        // Faire les actions correspondantes en fonction de l'action commandée
        if (buttonPressed.equals("rechercher")) {
                // Appeler la méthode de recherche du controller avec le terme de recherche
                RechercherController rechercherController = new RechercherController();
                rechercherController.rechercher(film);
        } else if (buttonPressed.equals("Se connecter")) {
            ConnexionView connexionView = new ConnexionView(statutUtilisateur);
            connexionView.setVisible(true);
        } else if (buttonPressed.equals("Ajouter Film")) {
            AjouterFilmView ajouterFilmView = new AjouterFilmView(statutUtilisateur);
            ajouterFilmView.setVisible(true);
        } else if (buttonPressed.equals("Ajouter Utilisateur")) {
            CreationCompteView creationCompteView = new CreationCompteView(statutUtilisateur);
            creationCompteView.setVisible(true);
        } else if (buttonPressed.equals("Film")) {
            InfoFilm infoFilm = new InfoFilm();
            infoFilm.infoFilmView(film,statutUtilisateur);
        }
    }
}
