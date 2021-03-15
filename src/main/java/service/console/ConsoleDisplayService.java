package service.console;

import domain.Produit;
import domain.Profil;
import domain.User;
import service.DisplayService;

public class ConsoleDisplayService implements DisplayService {

    public void afficherBienvenue() {
        System.out.println("Bienvenu sur la plateforme de Gestion de stock de la boutique informatique!");
    }

    public void afficherMenuPrincipal() {
        int choix = 0;
            //clearConsole();
            System.out.println("---------------------GESTION STOCK BOUTIQUE INFORMATIQUE------");
            System.out.println("1--------------------GESTION UTILISATEURS");
            System.out.println("2--------------------GESTION PROFILS");
            System.out.println("3--------------------GESTION DES COMMANDES");
            System.out.println("4--------------------QUITTER");
    }


    public void afficherListeProfils(Profil[] profils) {
        System.out.println("Les profils disponibles sont:");
        for (int i = 0; i < profils.length; i++) {
            Profil profil = profils[i];
            System.out.println(String.format("> %s %s", profil.getId(), profil.getLibelle()));
        }
    }

    public void afficherListeUtilisateurs(User[] users) {
        System.out.println("Les utilisateurs disponibles sont:");
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            System.out.println(String.format("> %s %s %s", user.getId(), user.getPrenom(), user.getNom()));
        }
    }

    public void afficherListeProduits(Produit[] produits) {
        System.out.println("Les produits disponibles sont:");
        for (int i = 0; i < produits.length; i++) {
            Produit produit = produits[i];
            System.out.println(String.format("> id: %s libelle produit: %s", produit.getId(), produit.getLibelle()));
        }
    }

    public void faireCommande() {

    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }
}
