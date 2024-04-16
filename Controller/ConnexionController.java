package Controller;

public class ConnexionController {

    public static void connecter(String[] informationsConnexion) {
        //commentaires
        String statutUtilisateur = ConnexionModele.connecter(informationsConnexion);

        if (statutUtilisateur != null) {
            // Si les informations de connexion sont valides, ouvrir la page appropriée
            if (statutUtilisateur.equals("client")) {
                System.out.println("page client");
                //ClientView.ouvrirPageClient();
            } else if (statutUtilisateur.equals("employe")) {
                //EmployeView.ouvrirPageEmploye();
                System.out.println("page client");
            }
        } else {
            // Si les informations de connexion sont invalides, afficher un message d'erreur
            System.out.println("je change pour le git");
            System.out.println("je change pour le git");
            System.out.println("je change pour le git");
            System.out.println("je change pour le git");
            System.out.println("je change pour le git");
            System.out.println("je change pour le git");
            System.out.println("je change pour le git");
            //ConnexionView.afficherMessageErreur();
        }
    }
}
