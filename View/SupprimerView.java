package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import Controller.SupprimerFilmController;
import Modele.ListeFilms.Film;
import Modele.ListeFilms;
import Modele.SupprimerFilmModele;

public class SupprimerFilmView extends JFrame {
    public SupprimerFilmView() {
        // Charger la liste des films
        ListeFilms listeFilms = new ListeFilms();
        List<Film> films = listeFilms.getFilms();

        // Créer un JPanel pour contenir les films avec un GridLayout
        JPanel filmsPanel = new JPanel(new GridLayout(0, 4, 10, 10)); // 4 colonnes, espacement horizontal et vertical de 10 pixels

        // Parcourir la liste des films
        for (Film film : films) {
            // Créer un bouton avec l'affiche du film
            JButton filmButton = createFilmButton(film);

            // Ajouter un écouteur d'événements au bouton
            filmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Appeler le contrôleur de suppression de film
                    int idFilm = film.getFilmId();
                    SupprimerFilmController controller = new SupprimerFilmController();
                    controller.supprimerFilm(idFilm); // Passer le film cliqué au contrôleur
                }
            });

            // Ajouter le bouton au panneau des films
            filmsPanel.add(filmButton);
        }

        // Ajouter le panneau des films dans un JScrollPane
        JScrollPane scrollPane = new JScrollPane(filmsPanel);

        // Configurer la fenêtre
        setTitle("Liste des films");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600)); // Taille de la fenêtre
        getContentPane().add(scrollPane, BorderLayout.CENTER); // Ajouter le JScrollPane à la fenêtre
        pack(); // Redimensionner la fenêtre pour s'adapter au contenu
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        setVisible(true); // Rendre la fenêtre visible
    }

    // Méthode pour créer un bouton avec l'affiche du film
    private JButton createFilmButton(Film film) {
        JButton button = new JButton();

        // Chemin de l'image
        String currentDirectory = System.getProperty("user.dir");
        // Créer le chemin relatif vers le dossier contenant les images
        String imagePath = currentDirectory + File.separator + "View" + File.separator + film.getNom() + ".png";

        // Vérifier si l'image existe
        if (new File(imagePath).exists()) {
            // Créer une icône à partir de l'image
            ImageIcon icon = new ImageIcon(imagePath);

            // Redimensionner l'icône pour s'adapter au bouton
            Image img = icon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);

            // Définir l'icône du bouton
            button.setIcon(icon);
        } else {
            // Si l'image n'existe pas, utiliser le nom du film comme texte du bouton
            button.setText(film.getNom());
        }

        return button;
    }
}
