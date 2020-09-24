package fr.pgah.slam5;

public class CompteEpargne extends Compte {
    private final double TAUX = 0.01;
    private boolean estEtranger;

    public CompteEpargne(int num, boolean estEtranger) {
        super(num, estEtranger);
    }

    @Override
    public void appliquerInterets() {
        solde = (int) (solde * (1 + TAUX));
    }

    @Override
    public String toString() {
        String provenance;
        if (estEtranger) {
            provenance = "étranger";
        } else {
            provenance = "non-étranger";
        }

        return "\n\tCompte épargne no. " + numero + ": solde = " + solde + " (" + provenance + ")";
    }

    @Override
    public boolean offreGarantiesSuffisantesPour(int montant) {
        return (solde >= montant / 2);

    }

}
