package View;

import Controller.AjouterFilmController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterFilmView extends JFrame {
    private final JTextField titreField;
    private final JTextField realisateurField;
    private JTextField dureeField;
    private JTextField prixField;

    public  AjouterFilmView(String statutUtilisateur) {
        JPanel contentPane = new JPanel(new GridLayout(0, 2));
        JLabel titreLabel = new JLabel("Titre:");
        titreField = new JTextField();
        JLabel realisateurLabel = new JLabel("Réalisateur:");
        realisateurField = new JTextField();


        contentPane.add(titreLabel);
        contentPane.add(titreField);
        contentPane.add(realisateurLabel);
        contentPane.add(realisateurField);

        JButton ajouterButton = new JButton("Ajouter Film");
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer les données saisies par l'utilisateur
                String titre = titreField.getText();
                String realisateur = realisateurField.getText();


                AjouterFilmController.ajouterFilm(titre, realisateur, statutUtilisateur);
            }
        });
        contentPane.add(ajouterButton);

        setTitle("Ajouter Film");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void afficherMessage(String s) {
        JTextArea infoTextArea = new JTextArea();
        infoTextArea.append(s);
    }

    public void setController(AjouterFilmController ajouterFilmController) {
    }

    public void resetChamps() {
        titreField.setText("");
        realisateurField.setText("");
    }

}