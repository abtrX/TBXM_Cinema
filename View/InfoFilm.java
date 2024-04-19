package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import Modele.ListeFilms.Film;

public class InfoFilm extends JFrame {
    private Film film;
    private JLabel imageLabel; // Composant pour afficher l'image

    public void infoFilmView(Film film) {
        this.film = film;

        // Configuration de la fenêtre
        setTitle("Détails du film");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400); // Taille de la fenêtre

        JPanel panelInfo= new JPanel(new GridLayout(0,1));
        JLabel nomFilmPanel = new JLabel("TITRE : "+film.getNom());
        JLabel realisateurFilmPanel = new JLabel("Réalisé par  : "+film.getAuteur());

        // Chargement de l'image à partir du chemin spécifié
        BufferedImage image = loadImage(".../TBXM_Cinema/View/"+film.getFilmId()+".png");
        if (image != null) {
            imageLabel = new JLabel(new ImageIcon(image));
            add(imageLabel, BorderLayout.CENTER); // Ajout de l'image au centre
        }

        panelInfo.add(nomFilmPanel);
        panelInfo.add(realisateurFilmPanel);
        add(panelInfo, BorderLayout.NORTH); // Ajout des infos en haut

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Méthode pour charger une image à partir du chemin spécifié
    private BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
