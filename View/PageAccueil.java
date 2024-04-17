package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import Modele.ListeFilms.Film;
import Modele.ListeFilms;

public class PageAccueil extends JFrame {
    private Connection connexion;

    public PageAccueil(Connection connexion) {
        this.connexion = connexion;
        // Créer le panneau principal avec un fond sombre
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setLayout(new BorderLayout());

        // Barre de recherche
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Rechercher");
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Bouton de connexion
        JButton loginButton = new JButton("Se connecter");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnexionView connexionView = new ConnexionView();
                connexionView.setVisible(true);
            }
        });
        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        loginPanel.add(loginButton);

        // Liste des films
        JPanel moviesPanel = new JPanel(new GridLayout(0, 1));
        ListeFilms listeFilms = new ListeFilms();

        // Obtenez la liste des films en utilisant la connexion passée en paramètre
        List<Film> films = listeFilms.getFilms(connexion);

        // Pour chaque film, créer un bouton représentant ce film
        for (Film film : films) {
            JButton filmButton = new JButton(film.getNom()); // Suppose que getTitre() retourne le titre du film
            filmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Gérer l'action lorsque l'utilisateur clique sur ce bouton de film
                    // Par exemple, ouvrir une nouvelle fenêtre pour afficher les détails du film
                }
            });
            moviesPanel.add(filmButton); // Ajouter le bouton de film au panneau des films
        }


        // Ajouter les composants au panneau principal
        contentPane.add(searchPanel, BorderLayout.NORTH);
        contentPane.add(moviesPanel, BorderLayout.CENTER);
        contentPane.add(loginPanel, BorderLayout.SOUTH);

        // Configurer la fenêtre
        setTitle("Page d'accueil");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

