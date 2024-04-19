package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import java.io.File;


import Modele.ListeFilms.Film;
import Modele.ListeFilms;

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

        // Créer un JPanel pour les films et utiliser un GridLayout avec un nombre fixe de colonnes
        JPanel moviesPanel = new JPanel(new GridLayout(0, 3)); // 3 colonnes par ligne

        ListeFilms listeFilms = new ListeFilms();
        List<Film> films = listeFilms.getFilms();

        for (Film film : films) {
            String imagePath = "C:\\ECE\\Ing 3\\Java\\TBXM_Cinema\\View\\" + film.getFilmId() + ".png";

            if (!new File(imagePath).exists()) {
                System.err.println("L'image n'existe pas : " + imagePath);
                continue; // Passer au film suivant
            }

            try {
                ImageIcon icon = new ImageIcon(imagePath);

                if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                    System.err.println("Erreur lors du chargement de l'image : " + imagePath);
                    continue; // Passer au film suivant
                }

                JButton filmButton = new JButton(icon);
                JLabel titleLabel = new JLabel(film.getNom(), SwingConstants.CENTER);

                // Créer un JPanel pour chaque film
                JPanel filmPanel = new JPanel(new BorderLayout());
                filmPanel.add(filmButton, BorderLayout.CENTER);
                filmPanel.add(titleLabel, BorderLayout.SOUTH);

                // Ajouter le JPanel du film au panneau des films
                moviesPanel.add(filmPanel);

            } catch (Exception ex) {
                System.err.println("Erreur lors du chargement de l'image : " + ex.getMessage());
            }
        }


        // Ajouter le panneau des films dans un JScrollPane
        JScrollPane moviesScrollPane = new JScrollPane(moviesPanel);

        // Ajouter le JScrollPane à la fenêtre
        add(moviesScrollPane, BorderLayout.CENTER);

        // Créer un JPanel pour contenir les boutons et le JScrollPane
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(moviesScrollPane, BorderLayout.CENTER);

        setTitle("Page d'accueil");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
