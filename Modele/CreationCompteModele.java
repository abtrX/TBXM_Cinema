package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreationCompteModele {
    private Connection connexion;

    public CreationCompteModele(Connection connexion) {
        this.connexion = connexion;
    }

    public void actualiserNom(int idUtilisateur, String nouveauNom) throws SQLException {
        String sql = "UPDATE utilisateurs SET Nom=? WHERE id=?";
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, nouveauNom);
        statement.setInt(2, idUtilisateur);
        statement.executeUpdate();
    }

    public void actualiserMail(int idUtilisateur, String nouveauMail) throws SQLException {
        String sql = "UPDATE utilisateurs SET Mail=? WHERE id=?";
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, nouveauMail);
        statement.setInt(2, idUtilisateur);
        statement.executeUpdate();
    }

    public void actualiserMotDePasse(int idUtilisateur, String nouveauMotDePasse) throws SQLException {
        String sql = "UPDATE utilisateurs SET MotDePasse=? WHERE id=?";
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, nouveauMotDePasse);
        statement.setInt(2, idUtilisateur);
        statement.executeUpdate();
    }

    // Vous pouvez ajouter d'autres méthodes pour actualiser d'autres informations sur l'utilisateur
}
