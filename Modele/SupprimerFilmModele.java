package Modele;

import DAO.SupprimerFilmDAO;

import java.sql.SQLException;

public class SupprimerFilmModele {
    private SupprimerFilmDAO supprimerFilmDAO;

    public SupprimerFilmModele() {
        this.supprimerFilmDAO = new SupprimerFilmDAO();
    }

    public void supprimerFilm(int idFilm) throws SQLException {
        supprimerFilmDAO.supprimerFilm(idFilm);
    }
}