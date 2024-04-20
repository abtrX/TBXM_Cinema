package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import java.io.File;


import Controller.PageAccueilController;
import Modele.ListeFilms.Film;
import Modele.ListeFilms;
import Controller.RechercherController;

public class PageAccueil extends JFrame {

    public PageAccueil(String statutUtilisateur) {
        Connection connexion;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Utiliser FlowLayout pour aligner les composants au centre

        // Barre de recherche
        JTextField searchField = new JTextField(20); // Spécifiez la largeur du champ de recherche
        JButton searchButton = new JButton("Rechercher");

        ListeFilms listeFilms = new ListeFilms();
        List<Film> films = listeFilms.getFilms();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer le texte saisi dans le champ de recherche
                String searchTerm = searchField.getText();
                String boutonPresse = "rechercher";
                for (ListeFilms.Film film : films) {
                    if (film.getNom().equalsIgnoreCase(searchTerm)) {
                        PageAccueilController controller = new PageAccueilController(searchTerm, boutonPresse, statutUtilisateur, film);
                        controller.onAction(films);
                        break;
                    }
                }
            }
        });

        // Bouton de connexion
        JButton loginButton = new JButton("Se connecter");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la nouvelle fenêtre de connexion
                String searchTerm = null;
                String boutonPresse = "Se connecter";
                Film film = null;
                PageAccueilController controller = new PageAccueilController(searchTerm, boutonPresse, statutUtilisateur, film);
                controller.onAction(films);
            }
        });

        // Bouton d'ajout de film (pour les employés)
        JButton ajoutFilm = new JButton("Ajouter Film");
        ajoutFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = null;
                String boutonPresse = "Ajouter Film";
                Film film = null;
                PageAccueilController controller = new PageAccueilController(searchTerm, boutonPresse, statutUtilisateur, film);
                controller.onAction(films);
            }
        });
        // Bouton d'ajout de film (pour les employés)
        JButton ajoutUser = new JButton("Ajouter Utilisateur");
        ajoutUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = null;
                String boutonPresse = "Ajouter Utilisateur";
                Film film = null;
                PageAccueilController controller = new PageAccueilController(searchTerm, boutonPresse, statutUtilisateur, film);
                controller.onAction(films);
            }
        });
        // Créer un JPanel pour les films et utiliser un GridBagLayout
        JPanel moviesPanel = new JPanel(new GridBagLayout());

        // Créer un objet GridBagConstraints pour contrôler le positionnement et la taille des composants
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Permet aux composants de remplir l'espace disponible horizontalement
        gbc.gridx = 0; // Commencer à partir de la première colonne
        gbc.gridy = 0; // Commencer à partir de la première ligne
        gbc.insets = new Insets(10, 10, 10, 10); // Marge autour de chaque composant

        // Créer un objet Dimension avec les dimensions souhaitées
        Dimension buttonSize = new Dimension(350, 411); // Largeur: 150 pixels, Hauteur: 200 pixels

        for (Film film : films) {
            final Film currentFilm = film; // Déclaration de la variable finale en dehors de la classe anonyme
            String imagePath = "C:\\Users\\maxim\\Desktop\\ECE\\INGE 3\\JAVA\\TBXM_Cinema\\View\\" + currentFilm.getFilmId() + ".png";

            if (new File(imagePath).exists()) {
                try {
                    ImageIcon icon = new ImageIcon(imagePath);

                    if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                        System.err.println("Erreur lors du chargement de l'image : " + imagePath);
                        continue; // Passer au film suivant
                    }

                    JButton filmButton = new JButton(icon);

                    JLabel filmLabel = new JLabel(film.getNom());

                    // Créer un JPanel pour contenir le bouton et le label, disposés verticalement
                    JPanel filmPanel = new JPanel(new BorderLayout());
                    filmPanel.add(filmButton, BorderLayout.CENTER);
                    filmPanel.add(filmLabel, BorderLayout.SOUTH);

                    // Définir la taille préférée du bouton
                    filmButton.setPreferredSize(buttonSize);

                    // Définir la taille maximale du bouton pour garantir que le GridBagLayout respecte la taille préférée
                    filmButton.setMaximumSize(buttonSize);
                    filmButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Utilisez currentFilm au lieu de film ici
                            String searchTerm = null;
                            String boutonPresse = "Film";
                            PageAccueilController controller = new PageAccueilController(searchTerm, boutonPresse, statutUtilisateur, currentFilm);
                            controller.onAction(films);
                        }
                    });

                    // Ajouter le bouton au panneau des films avec les contraintes définies
                    moviesPanel.add(filmPanel, gbc);

                    // Passer à la prochaine colonne pour le prochain bouton
                    gbc.gridx++;

                    // Si la colonne atteint la largeur de la fenêtre, passer à la ligne suivante
                    if (gbc.gridx == 4) {
                        gbc.gridx = 0; // Revenir à la première colonne
                        gbc.gridy++;   // Aller à la ligne suivante
                    }
                } catch (Exception ex) {
                    System.err.println("Erreur lors du chargement de l'image : " + ex.getMessage());
                }
            } else {
                // Si aucune image n'est disponible, créer un bouton avec le nom du film
                JButton filmButton = new JButton(film.getNom());

                // Créer un JPanel pour contenir le bouton, disposé verticalement
                JPanel filmPanel = new JPanel(new BorderLayout());
                filmPanel.add(filmButton, BorderLayout.CENTER);

                // Définir la taille préférée du bouton
                filmButton.setPreferredSize(buttonSize);

                // Définir la taille maximale du bouton pour garantir que le GridBagLayout respecte la taille préférée
                filmButton.setMaximumSize(buttonSize);
                filmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Utilisez currentFilm au lieu de film ici
                        String searchTerm = null;
                        String boutonPresse = "Film";
                        PageAccueilController controller = new PageAccueilController(searchTerm, boutonPresse, statutUtilisateur, currentFilm);
                        controller.onAction(films);
                    }
                });

                // Ajouter le bouton au panneau des films avec les contraintes définies
                moviesPanel.add(filmPanel, gbc);

                // Passer à la prochaine colonne pour le prochain bouton
                gbc.gridx++;

                // Si la colonne atteint la largeur de la fenêtre, passer à la ligne suivante
                if (gbc.gridx == 4) {
                    gbc.gridx = 0; // Revenir à la première colonne
                    gbc.gridy++;   // Aller à la ligne suivante
                }
            }
        }

        if (statutUtilisateur == null) {
            // Ajouter les composants au buttonPanel
            buttonPanel.add(searchField);
            buttonPanel.add(searchButton);
            buttonPanel.add(loginButton, BorderLayout.WEST);
        } else if (statutUtilisateur.equals("client")) {
            // Ajouter les composants au buttonPanel
            buttonPanel.add(searchField);
            buttonPanel.add(searchButton);
        } else if (statutUtilisateur.equals("employe")) {
            // Ajouter les composants au buttonPanel
            buttonPanel.add(ajoutFilm, BorderLayout.EAST);
            buttonPanel.add(ajoutUser);
            buttonPanel.add(searchField);
            buttonPanel.add(searchButton);
        }

        // Ajouter le buttonPanel à la partie nord de la fenêtre
        add(buttonPanel, BorderLayout.NORTH);

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