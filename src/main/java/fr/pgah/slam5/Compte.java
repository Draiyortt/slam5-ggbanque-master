package fr.pgah.slam5;

public class Compte {
  private int solde;
  private boolean estEtranger;
  private double taux = 0.01;

  public Compte(boolean estEtranger) {
    this.estEtranger = estEtranger;
  }

  public int getSolde() {
    return solde;
  }

  public boolean getEstEtranger() {
    return estEtranger;
  }

  public void crediter(int montant) {
    solde = solde + montant;
  }

  public void appliquerInterets() {
    solde = (int) (solde * (1 + taux));
  }
}
