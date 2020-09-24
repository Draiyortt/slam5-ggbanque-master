package fr.pgah.slam5;

public class CompteCourant extends Compte {

    private boolean estEtranger;

    public CompteCourant(int num, boolean estEtranger) {
        super(num, estEtranger);
    }

    @Override
    public void appliquerInterets() {

    }

    @Override
    public String toString() {
        String provenance;
        if (estEtranger) {
            provenance = "étranger";
        } else {
            provenance = "non-étranger";
        }

        return "\n\tCompte courant no. " + numero + ": solde = " + solde + " (" + provenance + ")";
    }

    @Override
    public boolean offreGarantiesSuffisantesPour(int montant) {

        return solde >= 2 * montant / 3;

    }

}