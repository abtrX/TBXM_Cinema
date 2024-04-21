package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Controller.SuppUtilisateurController;
import Modele.ListeUtilisateurs;

public class SuppUtilisateurView extends JFrame {
    public SuppUtilisateurView(List<ListeUtilisateurs.Utilisateur> utilisateurs) {
        // Configuration de la fenêtre
        setTitle("Supprimer un utilisateur");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300); // Taille de la fenêtre

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Liste des utilisateurs :");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        // Création d'un groupe de boutons pour les utilisateurs
        ButtonGroup buttonGroup = new ButtonGroup();

        // Ajout des boutons radio pour chaque utilisateur
        for (ListeUtilisateurs.Utilisateur utilisateur : utilisateurs) {
            JRadioButton radioButton = new JRadioButton(utilisateur.getStatut() + " - " + utilisateur.getEmail());
            radioButton.setActionCommand(utilisateur.getEmail()); // Utilisez l'adresse mail de l'utilisateur comme actionCommand
            radioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonGroup.add(radioButton);
            panel.add(radioButton);
        }

        JButton supprimerButton = new JButton("Supprimer");
        supprimerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer l'ID de l'utilisateur sélectionné
                String mailUser = buttonGroup.getSelection().getActionCommand();

                // Appeler le contrôleur pour supprimer l'utilisateur
                SuppUtilisateurController controller = new SuppUtilisateurController();
                controller.supprimerUtilisateur(mailUser);

                // Actualiser la vue après la suppression
                dispose(); // Ferme la fenêtre actuelle
            }
        });
        panel.add(supprimerButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
