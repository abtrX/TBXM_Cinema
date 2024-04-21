package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ConnexionBDD;

public class ListeUtilisateurs {

    public static List<Utilisateur> getUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        Connection connexion = null;
        try {
            connexion = ConnexionBDD.obtenirConnexion();
            String sql = "SELECT * FROM Utilisateur";
            PreparedStatement statement = connexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Pour chaque ligne de résultat, créer un objet Utilisateur et l'ajouter à la liste
                Utilisateur utilisateur = new Utilisateur(resultSet.getString("Mail"), resultSet.getString("MotDePasse"), resultSet.getString("Nom"),resultSet.getString("Statut"));
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connexion != null) {
                    connexion.close(); // Fermeture de la connexion à la base de données
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return utilisateurs;
    }

    // Classe interne pour représenter un utilisateur
    public static class Utilisateur {
        private String  mail;
        private String nom;
        private String mdp;
        private String statut;

        public Utilisateur(String mail, String nom, String mdp,String statut) {
            this.mail = mail;
            this.nom = nom;
            this.mdp = mdp;
            this.statut = statut;
        }



        public String getNom() {
            return nom;
        }

        public String getEmail() {
            return mail;
        }
        public String getStatut() {
            return statut;
        }
    }
}
