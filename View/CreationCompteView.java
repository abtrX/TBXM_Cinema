package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.CreerCompteController;

public class CreationCompteView extends JFrame {

    private JTextField nomField;
    private JTextField mailField;
    private JPasswordField passwordField;
    private JTextField statutField;

    public CreationCompteView() {
        setTitle("Création de compte");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        JLabel nomLabel = new JLabel("Nom : ");
        nomField = new JTextField();
        JLabel mailLabel = new JLabel("Mail : ");
        mailField = new JTextField();
        JLabel passwordLabel = new JLabel("Mot de passe : ");
        passwordField = new JPasswordField();
        JLabel statutLabel = new JLabel("Statut (client ou employé) : ");
        statutField = new JTextField();
        JButton creerButton = new JButton("Créer");

        panel.add(nomLabel);
        panel.add(nomField);
        panel.add(mailLabel);
        panel.add(mailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(statutLabel);
        panel.add(statutField);
        panel.add(new JLabel()); // Pour occuper la colonne vide
        panel.add(creerButton);

        add(panel);

        creerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String mail = mailField.getText();
                String motDePasse = new String(passwordField.getPassword());
                String statut = statutField.getText();

                // Envoyer les données au contrôleur
                // Vous pouvez utiliser une méthode du contrôleur pour gérer cela
                String[] newUser = {nom, mail, motDePasse, statut};
                // Passer les données au contrôleur
                // Vous pouvez utiliser une méthode du contrôleur pour gérer cela
                CreerCompteController.creerCompte(newUser);
                // Rediriger vers la page de connexion
                CreerCompteController.redirigerVersConnexion();
            }
        });

        setVisible(true);
    }
}
