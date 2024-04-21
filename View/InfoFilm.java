package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.ListeFilms.Film;
import Controller.InfoFilmController;

public class InfoFilm extends JFrame {
    private Film film;
    private JPanel disponibilitesPanel; // Panel pour les boutons de disponibilités

    public void infoFilmView(Film film,String statutUtilisateur) {


        this.film = film;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Utiliser FlowLayout pour aligner les composants au centre

        JButton ajoutSeance = new JButton("Ajouter des séances");

        ajoutSeance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la nouvelle classe pour ajouter des séances
                // Vous pouvez appeler une méthode de votre controller pour gérer cette action
                InfoFilmController controller = new InfoFilmController(film.getFilmId());
                // Créer une nouvelle instance de la classe pour ajouter des séances
                AjouterSeanceView ajoutSeanceView = new AjouterSeanceView(film);
                // Afficher la fenêtre
                ajoutSeanceView.setVisible(true);
            }
        });


        // Configuration de la fenêtre
        setTitle("Détails du film");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400); // Taille de la fenêtre

        // Création du contrôleur avec le film actuel
        InfoFilmController controller = new InfoFilmController(film.getFilmId());

        // Panneau pour les informations du film
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrage horizontal

        JLabel nomFilmPanel = new JLabel("TITRE : " + film.getNom());
        nomFilmPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrage horizontal
        JLabel realisateurFilmPanel = new JLabel("Réalisé par : " + film.getAuteur());
        realisateurFilmPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrage horizontal

        // Chemin de l'image
        String imagePath = "C:\\Users\\maxim\\Desktop\\ECE\\INGE 3\\JAVA\\TBXM_Cinema\\View\\" + film.getFilmId() + ".png";

        // Création du composant pour afficher l'image
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrage horizontal

        // Création du panel pour les boutons de disponibilités
        disponibilitesPanel = new JPanel();
        disponibilitesPanel.setLayout(new BoxLayout(disponibilitesPanel, BoxLayout.Y_AXIS));
        disponibilitesPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrage horizontal

        // Ajout des boutons de disponibilités au panel
        String[] disponibilites = controller.getDisponibilites();
        for (String disponibilite : disponibilites) {
            JButton button = new JButton(disponibilite);
            button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrage horizontal
            disponibilitesPanel.add(button);
        }

        // Ajout des composants au panelInfo
        panelInfo.add(nomFilmPanel);
        panelInfo.add(realisateurFilmPanel);
        panelInfo.add(imageLabel);
        panelInfo.add(disponibilitesPanel);

        if (statutUtilisateur == null) {
            panelInfo.add(nomFilmPanel);
            panelInfo.add(realisateurFilmPanel);
            panelInfo.add(imageLabel);
            panelInfo.add(disponibilitesPanel);
        } else if (statutUtilisateur.equals("client")) {
            panelInfo.add(nomFilmPanel);
            panelInfo.add(realisateurFilmPanel);
            panelInfo.add(imageLabel);
            panelInfo.add(disponibilitesPanel);
        } else if (statutUtilisateur.equals("employe")) {
            panelInfo.add(nomFilmPanel);
            panelInfo.add(realisateurFilmPanel);
            panelInfo.add(imageLabel);
            panelInfo.add(disponibilitesPanel);
            buttonPanel.add(ajoutSeance);
        }

        // Ajout du panelInfo à la fenêtre
        add(buttonPanel, BorderLayout.WEST); // Ajout des infos centrées
        add(panelInfo, BorderLayout.CENTER); // Ajout des infos centrées

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
