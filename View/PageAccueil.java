package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import Modele.ListeFilms.Film;
import Modele.ListeFilms;
import View.InfoFilm;

public class PageAccueil extends JFrame {

    public PageAccueil(String statutUtilisateur) {
        Connection connexion;
        JPanel buttonPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        buttonPanel.setLayout(new BorderLayout());

        // Barre de recherche
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Rechercher");

        buttonPanel.add(searchField);
        buttonPanel.add(searchButton);

        // Bouton de connexion
        JButton loginButton = new JButton("Se connecter");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnexionView connexionView = new ConnexionView(statutUtilisateur);
                connexionView.setVisible(true);
            }
        });
        buttonPanel.add(loginButton, BorderLayout.EAST);

        JButton ajoutFilm = new JButton("Ajouter Film");
        ajoutFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AjouterFilmView ajouterFilmView = new AjouterFilmView(statutUtilisateur);
                ajouterFilmView.setVisible(true);
            }
        });
        buttonPanel.add(ajoutFilm, BorderLayout.WEST);

        // Liste des films
        JPanel moviesPanel = new JPanel(new GridLayout(0, 1));
        ListeFilms listeFilms = new ListeFilms();

        // Obtenez la liste des films en utilisant la connexion passée en paramètre
        List<Film> films = listeFilms.getFilms();

        // Pour chaque film, créer un bouton représentant ce film
        for (Film film : films) {
            // Construire le chemin de l'image à partir de l'identifiant du film
            String imagePath = film.getFilmId() + ".png";

            // Charger l'image depuis le chemin spécifié
            ImageIcon icon = new ImageIcon(imagePath);

            // Créer un bouton avec l'image chargée et le titre du film comme texte
            JButton filmButton = new JButton(film.getNom(), icon); // Suppose que getNom() retourne le titre du film

            // Ajouter un écouteur d'événements pour gérer le clic sur le bouton de film
            filmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Gérer l'action lorsque l'utilisateur clique sur ce bouton de film

                    // Par exemple, ouvrir une nouvelle fenêtre pour afficher les détails du film

                    // Vous pouvez maintenant créer une instance de la classe InfoFilm et afficher les détails du film
                    InfoFilm infoFilm = new InfoFilm();
                    infoFilm.infoFilmView(film);
                }
            });

            // Ajouter le bouton de film au panneau des films
            moviesPanel.add(filmButton);
        }
        JPanel contentPane = new JPanel();
        // Ajouter les composants au panneau principal
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(moviesPanel, BorderLayout.CENTER);

        // Configurer la fenêtre
        setTitle("Page d'accueil");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
