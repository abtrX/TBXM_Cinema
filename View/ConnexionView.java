package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.ConnexionController;
import Controller.PageAccueilController;

public class ConnexionView extends JFrame {
    private JTextField mailField;
    private JPasswordField passwordField;

    public ConnexionView(String statutUtilisateur) {
        // Création de la fenêtre
        setTitle("Connexion");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
                // Tentative de connexion
                String statutUtilisateur = ConnexionController.connecter(informationsConnexion);
                if (statutUtilisateur != null) {
                    // Si la connexion réussit, fermer la fenêtre de connexion
                    dispose();
                    // Ouvrir la page d'accueil avec le statut utilisateur
                    PageAccueil pageAccueil = new PageAccueil(statutUtilisateur);
                    pageAccueil.setVisible(true);
                } else {
                    // Si la connexion échoue, afficher un message d'erreur
                    JOptionPane.showMessageDialog(ConnexionView.this, "Erreur de connexion. Veuillez réessayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Action listener pour le bouton d'inscription
        inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la vue d'inscription
                dispose(); // Fermer la fenêtre de connexion
                CreationCompteView inscriptionView = new CreationCompteView(statutUtilisateur);
                inscriptionView.setVisible(true);
            }
        });
    }
}
