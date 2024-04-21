package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import Controller.PaiementController;
import Controller.SupprimerFilmController;
import Modele.SeanceInfo;

public class PaiementView extends JFrame {
    private JLabel seanceInfoLabel;
    private JTextField nombreBilletsField;
    private JButton payerButton;

    public PaiementView(SeanceInfo disponibilites) {
        // Configuration de la fenêtre
        setTitle("Paiement");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200); // Taille de la fenêtre

        // Création du panneau principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrage horizontal

        // Récupérer les informations de la séance et les formater
        String seanceInfoText = "Séance : " + disponibilites.getSeanceId() + " - Salle : " + disponibilites.getNumSalle() +
                " - Date : " + disponibilites.getDate() + " - Heure : " + disponibilites.getHeure() +
                " - Places disponibles : " + disponibilites.getPlacesDispo();

        // Création du label pour afficher les informations de la séance
        seanceInfoLabel = new JLabel(seanceInfoText);
        seanceInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrage horizontal

        // Création du champ de texte pour entrer le nombre de billets
        nombreBilletsField = new JTextField(10);
        nombreBilletsField.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrage horizontal

        // Création du bouton pour effectuer le paiement
        payerButton = new JButton("Payer");
        payerButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrage horizontal

        // Ajout d'un écouteur d'événements au bouton de paiement
        payerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer le texte saisi dans le champ de texte
                String nombreBilletsText = nombreBilletsField.getText();

                try {
                    // Convertir le texte en entier
                    int nombreBillets = Integer.parseInt(nombreBilletsText);

                    // Appeler le contrôleur avec la liste des disponibilités, l'identifiant de la séance et le nombre de billets en paramètres
                    PaiementController controller = new PaiementController(disponibilites);
                    controller.processPayment(disponibilites, nombreBillets); // Ajoutez la liste des disponibilités

                    // Fermer la fenêtre après le traitement du paiement
                    dispose();
                } catch (NumberFormatException ex) {
                    // Afficher un message d'erreur si la conversion échoue
                    JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide de billets.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Ajout des composants au panneau principal
        mainPanel.add(seanceInfoLabel);
        mainPanel.add(nombreBilletsField);
        mainPanel.add(payerButton);

        // Ajout du panneau principal à la fenêtre
        add(mainPanel);
    }
}
