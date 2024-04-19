package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import Controller.CreerCompteController;

public class CreationCompteView extends JFrame {

    private JTextField nomField;
    private JTextField mailField;
    private JPasswordField passwordField;
    private JTextField statutField;

    public CreationCompteView(String statutUtilisteur) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Création de compte");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel nomLabel = new JLabel("Nom : ");
        nomField = new JTextField();
        panel.add(nomLabel);
        panel.add(nomField);
        JLabel mailLabel = new JLabel("Mail : ");
        mailField = new JTextField();
        panel.add(mailLabel);
        panel.add(mailField);
        String statutTempo = statutUtilisteur;
        if ("employe".equals(statutTempo)) {
            JLabel statutLabel = new JLabel("Statut (client ou employé) : ");
            statutField = new JTextField();
            panel.add(statutLabel);
            panel.add(statutField);
        }

        JLabel passwordLabel = new JLabel("Mot de passe : ");
        passwordField = new JPasswordField();
        panel.add(passwordLabel);
        panel.add(passwordField);

        JButton creerButton = new JButton("Créer");
        panel.add(new JLabel()); // Pour occuper la colonne vide
        panel.add(creerButton);

        add(panel);

        creerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String mail = mailField.getText();
                String motDePasse = new String(passwordField.getPassword());
                String statut = "client";
                if (statutUtilisteur == "employe") {
                    statut = statutField.getText();
                }
                // Envoyer les données au contrôleur
                // Vous pouvez utiliser une méthode du contrôleur pour gérer cela
                String[] newUser = {nom, mail, motDePasse, statut};
                // Passer les données au contrôleur
                // Vous pouvez utiliser une méthode du contrôleur pour gérer cela
                CreerCompteController.creerCompte(newUser);
                // Rediriger vers la page de connexion
                CreerCompteController.redirigerVersConnexion(statut);
            }
        });

        setVisible(true);
    }
}
