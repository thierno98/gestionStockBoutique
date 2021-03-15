package service.console;

import domain.Produit;
import domain.Profil;
import domain.User;
import repository.ProduitRepository;
import repository.ProfilRepository;
import repository.UserRepository;
import repository.jdbc.DataSource;
import repository.jdbc.JdbcProduitRepository;
import repository.jdbc.JdbcProfilRepository;
import repository.jdbc.JdbcUserRepository;
import service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerMenuService implements MenuService {
    private static  DataSource dataSource;
    private static Scanner scanner;
    private UserRepository userRepository;
    public ScannerMenuService(DataSource dataSource) {
        scanner = new Scanner(System.in);
        this.dataSource = dataSource;
        userRepository = new JdbcUserRepository(dataSource);
    }

    public void afficherMenu()
    {
        ConsoleDisplayService consoleDisplayService = new ConsoleDisplayService();
        consoleDisplayService.afficherBienvenue();  //afficher le message de bienvenue
        consoleDisplayService.afficherMenuPrincipal();  //afficher menu principale
        int index = Integer.parseInt(scanner.nextLine());
        switch (index)
        {
            case 1:
                afficherGestionUtilisateurs();
                scanner.nextInt();
                break;
            case 2:
                afficherGestionProfils();
                scanner.nextInt();
                break;
            case 3:
                GestionProduits();
                break;
            case 4:
                return;
        }

    }

    public static void afficherGestionUtilisateurs()
    {
        ConsoleDisplayService consoleDisplayService = new ConsoleDisplayService();
        UserRepository userRepository = new JdbcUserRepository(dataSource);
        User[] users = userRepository.getAll();
        consoleDisplayService.afficherListeUtilisateurs(users);
    }

    public static void afficherGestionProfils()
    {
        ConsoleDisplayService consoleDisplayService = new ConsoleDisplayService();
        ProfilRepository profilRepository = new JdbcProfilRepository(dataSource);
        Profil[] profils = profilRepository.getAll();
        consoleDisplayService.afficherListeProfils(profils);
    }

    public static void GestionProduits()
    {
        ConsoleDisplayService consoleDisplayService = new ConsoleDisplayService();
        int rep = 1;
        List<Produit> produitsChoisis = new ArrayList<Produit>();
        while(rep == 1)
        {
            ProduitRepository produitRepository = new JdbcProduitRepository(dataSource);
            Produit[] produits = produitRepository.getAll();
            consoleDisplayService.afficherListeProduits(produits);
            System.out.println("Saisir le libelle du produit");
            String _produitLibelle = scanner.nextLine();
            Produit produitChoisi = GetProduitChoisiParLibelle(_produitLibelle, produits);
            if(produitChoisi != null)
            {
                produitsChoisis.add(produitChoisi);
            }
            System.out.println("Vous voulez choisir un autre produit?");
            System.out.println("1. Oui");
            System.out.println("2. Non");
            rep = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("La liste des produits choisis est la suivante");
        System.out.println("-----------------------------------------------------");
        consoleDisplayService.afficherListeProduits(produitsChoisis.toArray(new Produit[0]));
        System.out.println("Le montant est payé: " + GetPrixAPaye(produitsChoisis.toArray(new Produit[0])));
        System.out.println("-----------------------------------------------------");

    }

    public static Produit GetProduitChoisiParLibelle(String _libelle, Produit[] _produits)
    {
        for (Produit p: _produits
             ) {
            if(p.getLibelle().toLowerCase().equals(_libelle.toLowerCase()))
            {
                System.out.println("Le produit " + p.getLibelle() + " a été choisi");
                return p;
            }
        }
        System.out.println("Le produit choisi est introuvable");
        return null;
    }

    public static int GetPrixAPaye(Produit[] _produitsChoisi)
    {
        int prixAPaye = 0;
        for (Produit p: _produitsChoisi
             ) {
            prixAPaye += p.getPrixNormale();
        }
        return prixAPaye;
    }
}
