package View;

import java.util.Scanner;

public class CreationCompteView {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Creation de compte :");
    System.out.print("Nom : ");
    String nom = scanner.nextLine();

    System.out.print("Mail : ");
    String email = scanner.nextLine();

    System.out.print("Mot de passe : ");
    String motDePasse = scanner.nextLine();

    // Vous pouvez également ajouter une confirmation de mot de passe ici

    // En supposant que le statut par défaut soit "client"
    String statut = "client";

    // Une fois que vous avez collecté les informations, vous pouvez les transmettre au contrôleur pour le traitement ultérieur

    scanner.close();

}

