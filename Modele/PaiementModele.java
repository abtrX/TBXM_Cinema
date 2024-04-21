package Modele;

public class PaiementModele {
    private int placesDispo;

    public PaiementModele(int placesDispo) {
        this.placesDispo = placesDispo;
    }

    public boolean verifierDisponibiliteBillets(int nombreBillets) {
        return nombreBillets <= placesDispo;
    }
}
