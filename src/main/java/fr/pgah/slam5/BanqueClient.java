package fr.pgah.slam5;

import java.util.Scanner;

public class BanqueClient {

    private int numCompteSelectionne = 0;
    private Banque banque = new Banque();
    private Scanner scanner = new Scanner(System.in);;
    private boolean fin = false;

    void run() {
        while (!fin) {
            System.out.print(
                    "Entrez une commande (0 = quitter, 1 = nouveau compte, 2 = changer compte, 3 = créditer compte, 4 = demander emprunt, 5 = afficher infos comptes, 6 = appliquer intérêts): ");
            int choix = scanner.nextInt();
            traiterCommande(choix);
        }
        scanner.close();
    }

    private void traiterCommande(int cmd) {
        if (cmd == 0) {
            quitter();
        } else if (cmd == 1) {
            creerNouveauCompte();
        } else if (cmd == 2) {
            selectionnerCompte();
        } else if (cmd == 3) {
            crediterCompte();
        } else if (cmd == 4) {
            demanderEmprunt();
        } else if (cmd == 5) {
            afficherInfosComptes();
        } else if (cmd == 6) {
            appliquerInterets();
        }
    }

    private void quitter() {
        fin = true;
        System.out.println("À bientôt.");
    }

    private void creerNouveauCompte() {
        numCompteSelectionne = banque.creerCompte(demanderSiEtranger());
        System.out.println("Le numéro de votre nouveau compte est : " + numCompteSelectionne);
    }

    private boolean demanderSiEtranger() {
        System.out.println("Provenance (1 = étranger, 2 = non-étranger) : ");
        int entree = scanner.nextInt();
        return (entree == 1);
    }

    private void selectionnerCompte() {
        System.out.print("Entrez le numéro du compte : ");
        numCompteSelectionne = scanner.nextInt();
        int solde = comptes.get(numCompteSelectionne);
        System.out.println("Le solde du compte " + numCompteSelectionne + " est " + solde);
    }

    private void crediterCompte() {
        System.out.print("Entrez le montant : ");
        int montant = scanner.nextInt();
        banque.crediter(numCompteSelectionne, montant);
    }

    private void demanderEmprunt() {
        System.out.print("Entrez le montant de l'emprunt souhaité : ");
        int montant = scanner.nextInt();
        boolean accepte = banque.validationEmprunt(numCompteSelectionne, montant);
        if (accepte) {
            System.out.println("Votre demande est approuvé");
        } else {
            System.out.println("Votre demande est refusé");
        }
    }

    private void appliquerInterets() {
        banque.appliquerInterets();
    }

    private void afficherInfosComptes() {
        System.out.println(banque.toString());
    }

}
