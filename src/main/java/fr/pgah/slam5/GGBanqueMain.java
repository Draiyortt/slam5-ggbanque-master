package fr.pgah.slam5;

import java.util.HashMap;
import java.util.Scanner;

public class GGBanqueMain {

  public static void main(String[] args) {

    HashMap<Integer, Compte> comptes = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    Banque banque = new Banque(comptes);
    BanqueClient client = new BanqueClient(scanner, banque);
    client.run();
  }
}
