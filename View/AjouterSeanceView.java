package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modele.ListeFilms.Film;
import Controller.AjouterSeanceController;

public class AjouterSeanceView extends JFrame {
    private Film film;

    public AjouterSeanceView(Film film) {
        this.film = film;

        // Configuration de la fenêtre
        setTitle("Ajouter une séance pour " + film.getNom());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200); // Taille de la fenêtre

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Ajouter une séance pour " + film.getNom());
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel salleLabel = new JLabel("Salle:");
        JTextField salleField = new JTextField(20);
        JPanel sallePanel = new JPanel();
        sallePanel.add(salleLabel);
        sallePanel.add(salleField);
        sallePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField(20);
        JPanel datePanel = new JPanel();
        datePanel.add(dateLabel);
        datePanel.add(dateField);
        datePanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel heureLabel = new JLabel("Heure:");
        JTextField heureField = new JTextField(20);
        JPanel heurePanel = new JPanel();
        heurePanel.add(heureLabel);
        heurePanel.add(heureField);
        heurePanel.setAlignmentX(Component.CENTER_ALIGNMENT);



        JButton ajouterButton = new JButton("Ajouter");
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer la date et l'heure saisies

                int salle = Integer.parseInt(salleField.getText());
                String date = dateField.getText();
                String heure = heureField.getText();

                // Appeler le controller pour ajouter la séance
                AjouterSeanceController controller = new AjouterSeanceController();
                controller.ajouterSeance(film,salle, date, heure);
            }
        });
        ajouterButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titleLabel);

        panel.add(sallePanel);
        panel.add(datePanel);
        panel.add(heurePanel);
        panel.add(ajouterButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
