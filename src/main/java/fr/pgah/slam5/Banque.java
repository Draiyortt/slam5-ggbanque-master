package fr.pgah.slam5;

import java.util.HashMap;
import java.util.Set;

public class Banque {
  private HashMap<Integer, Compte> comptes = new HashMap<>();
  private int numDernierCompte = 0;

  public Banque(HashMap<Integer, Compte> comptes) {
    this.comptes = comptes;
  }

  public int creerCompte(boolean estEtranger) {
    int numCompte = numDernierCompte++;
    Compte nouveau = new Compte(estEtranger);
    comptes.put(numCompte, nouveau);
    return numCompte;
  }

  public int getSolde(int numCompte) {
    return comptes.get(numCompte).getSolde();
  }

  public void crediter(int numCompte, int montant) {
    Compte compte = comptes.get(numCompte);
    compte.crediter(montant);
  }

  public void appliquerInterets() {
    for (Compte compte : comptes.values()) {
      compte.appliquerInterets();
    }
  }

  public String toString() {
    Set<Integer> numerosDesComptes = comptes.keySet();
    String res = "La banque gère " + numerosDesComptes.size() + " comptes.";
    String provenance;
    for (int num : numerosDesComptes) {
      if (comptes.get(num).getEstEtranger()) {
        provenance = "étranger";
      } else {
        provenance = "non-étranger";
      }
      res += "\n\tCompte " + num + ": solde = " + comptes.get(num).getSolde() + " (" + provenance + ")";
    }
    return res;
  }

  public boolean autoriserEmprunt(int numCompte, int montant) {
    int solde = comptes.get(numCompte).getSolde();
    return (solde >= montant / 2);
  }

}
