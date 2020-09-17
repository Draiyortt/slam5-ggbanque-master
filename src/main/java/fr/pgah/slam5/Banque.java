package fr.pgah.slam5;

import java.util.HashMap;
import java.util.Set;

public class Banque {
    private HashMap<Integer, Compte> comptes = new HashMap<>();
    private double taux = 0.01;
    private int numDernierCompte = 0;

    public int creerCompte(boolean EstEtranger) {
        int numCompte = numDernierCompte++;
        Compte nouveau = new Compte(EstEtranger);
        comptes.put(numCompte, nouveau);
        return numCompte;
    }

    public int getSolde(int numCompte) {
        return comptes.get(numCompte).getSolde();
    }

    public void crediter(int numCompte, int montant) {
        Compte compte = comptes.get(numCompte);
        int solde = compte.getSolde();
        int nouveauSolde = solde + montant;
        compte.setSolde(nouveauSolde);
    }

    public void appliquerInterets() {
        // Set<Integer> numerosDesComptes = comptes.keySet();
        for (Compte compte : comptes.values()) {
            int solde = compte.getSolde();
            int nouveauSolde = (int) (solde * (1 + taux));
            compte.setSolde(nouveauSolde);
        }
    }

    public String toString() {
        Set<Integer> numerosDesComptes = comptes.keySet();
        String res = "La banque gère " + numerosDesComptes.size() + " comptes.";
        String provenance
        for (int num : numerosDesComptes) {
            if(comptes.get(num).getEstEtranger()){
                provenance = "étranger";
            }else{
                provenance = "non-étranger";
            }
            res += "\n\tCompte " + num + ": solde = " + comptes.get(num).getSolde() + comptes.get(num).getEstEtranger();
        }

        return res;
    }

    public boolean validationEmprunt(int numCompte, int montant) {

        int solde = comptes.get(numCompte).getSolde();

        return (solde >= montant / 2);

    }

}
