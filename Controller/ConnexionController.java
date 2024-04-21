package Controller;

import Modele.ConnexionModele;

public class ConnexionController {
    public static String connecter(String[] informationsConnexion) {
        return ConnexionModele.connecter(informationsConnexion);
    }
}
