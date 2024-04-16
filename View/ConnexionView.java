package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConnexionView extends JFrame {
    private JTextField mailField;
    private JPasswordField passwordField;

    public ConnexionView() {
        // Création de la fenêtre
        setTitle("Connexion ou Inscription");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Création des composants
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel mailLabel = new JLabel("Mail : ");
        mailField = new JTextField();
        JLabel passwordLabel = new JLabel("Mot de passe : ");
        passwordField = new JPasswordField();
        JButton connexionButton = new JButton("Connexion");
        JButton inscriptionButton = new JButton("S'inscrire");

        panel.add(mailLabel);
        panel.add(mailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(connexionButton);
        panel.add(inscriptionButton);

        // Ajout du panel à la fenêtre
        add(panel);

        // Action listener pour le bouton de connexion
        connexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail = mailField.getText();
                String password = new String(passwordField.getPassword());
                String[] informationsConnexion = {mail, password};
                // Passer les informations de connexion au contrôleur
                ConnexionController.connecter(informationsConnexion);
            }
        });

        // Action listener pour le bouton d'inscription
        inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la vue d'inscription
                dispose(); // Fermer la fenêtre de connexion
                CreationCompteView inscriptionView = new CreationCompteView();
                inscriptionView.setVisible(true);
            }
        });
    }

    // Méthode pour récupérer les informations de connexion
    public String[] saisirInformationsConnexion() {
        String mail = mailField.getText();
        String password = new String(passwordField.getPassword());
        return new String[]{mail, password};
    }
}
