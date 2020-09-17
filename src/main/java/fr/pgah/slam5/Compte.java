package fr.pgah.slam5;

public class Compte {
    private int solde;
    private boolean estEtranger;

    public Compte(boolean EstEtranger) {
        this.estEtranger = estEtranger;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int montant) {
        solde = montant;
    }

    public boolean getEstEtranger() {
        return estEtranger;
    }

}
