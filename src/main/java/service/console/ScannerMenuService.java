package service.console;

import domain.*;
import repository.*;
import repository.jdbc.*;
import service.DisplayService;
import service.MenuService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerMenuService implements MenuService {
    private static  DataSource dataSource;
    private final DisplayService displayService;
    private static Scanner scanner;
    private UserRepository userRepository;
    private ProduitRepository produitRepository;
    private ApproRepository approRepository;
    private EntrepriseRepository entrepriseRepository;
    private PersonneRepository personneRepository;
    private CommandeRepository commandeRepository;
    private DetailRepository detailRepository;
    public ScannerMenuService(DataSource dataSource, DisplayService displayService) {
        scanner = new Scanner(System.in);
        this.displayService = displayService;
        this.dataSource = dataSource;
        userRepository = new JdbcUserRepository(dataSource);
        produitRepository = new JdbcProduitRepository(dataSource);
        approRepository = new JdbcApproRepository(dataSource);
        entrepriseRepository = new JdbcEntrepriseRepository(dataSource);
        personneRepository = new JdbcPersonneRepository(dataSource);
        commandeRepository = new JdbcCommandeRepository(dataSource);
        detailRepository = new JdbcDetailRepository(dataSource);
    }

    public int faireChoixMenu(int max) {
        int choix = -1;
        System.out.println("CHOISIR UNE OPTION");
        do {
            choix =  Integer.parseInt(scanner.nextLine());
        }while (choix < 1 && choix > max);
        return choix;
    }

    public void flush() {
        scanner.nextLine();
    }

    /*********FONCTIONNALITES PRODUITS *****************/
    public void ajouterProduit() {
        System.out.println("***************AJOUT PRODUIT*******************");
        Produit produit = new Produit();
        produit.setId(produitRepository.getAll().length + 1);
        System.out.println("SAISIR LE LIBELLE DU PRODUIT:");
        produit.setLibelle(scanner.nextLine());
        System.out.print("SAISIR LE PRIX NORMALE : ");
        produit.setPrixNormale(Integer.parseInt(scanner.nextLine()));
        System.out.print("SAISIR LE PRIX minimal : ");
        produit.setPrixNormale(Integer.parseInt(scanner.nextLine()));
        System.out.print("SAISIR LA QUANTITE MINIMALE : ");
        produit.setQteMinimale(Integer.parseInt(scanner.nextLine()));
        System.out.print("SAISIR LA QUANTITE EN STOCK : ");
        produit.setQteStock(Integer.parseInt(scanner.nextLine()));
        produitRepository.addProduit(produit);
    }

    public Produit rechercherProduit() {
        System.out.println("SAISIR LE LIBELLE DU PRODUIT RECHERCHE");
        String libelle = scanner.nextLine();
        Produit retrievedProduit = new Produit();
        for (Produit p: produitRepository.getAll()
        ) {
            if(p.getLibelle().toLowerCase().equals(libelle))
            {
                retrievedProduit = p;
            }
        }

        displayService.afficherProduit(retrievedProduit);
        return retrievedProduit;
    }

    public void supprimerProduit() {
        System.out.println("SAISIR LE LIBELLE DU PRODUIT A SUPPRIME");
        String libelle = scanner.nextLine();
        Produit retrievedProduit = new Produit();
        for (Produit p: produitRepository.getAll()
        ) {
            if(p.getLibelle().toLowerCase().equals(libelle))
            {
                retrievedProduit = p;
            }
        }

        produitRepository.deleteProduit(retrievedProduit);
    }
    /*********FONCTIONNALITES USERS *****************/
    public void ajouterUser() {
        System.out.println("***************AJOUT USER*******************");
        User user = new User();
        user.setId(userRepository.getAll().length + 1);
        System.out.print("SAISIR L'ADRESSE: ");
        user.setAdresse(scanner.nextLine());
        System.out.print("SAISIR LE NOM: ");
        user.setNom(scanner.nextLine());
        System.out.print("SAISIR LE PRENOM: ");
        user.setPrenom(scanner.nextLine());
        System.out.print("SAISIR LE NUMERO DE TELEPHONE: ");
        user.setTelephone(scanner.nextLine());
        user.setProfil(1);
        System.out.print("SAISIR LE MOT DE PASSE: ");
        user.setPassword(scanner.nextLine());
        System.out.print("SAISIR LE LOGIN: ");
        user.setLogin(scanner.nextLine());
        userRepository.addUser(user);
    }

    public User rechercherUser() {
        System.out.println("SAISIR LE PRENOM DU USER");
        String libelle = scanner.nextLine();
        User retrievedUser = new User();
        for (User u: userRepository.getAll()
        ) {
            if(u.getPrenom().toLowerCase().equals(libelle.toLowerCase()))
            {
                displayService.afficherUser(u);
                retrievedUser = u;
            }
        }

        return retrievedUser;
    }

    public void supprimerUser() {
        System.out.println("SAISIR LE PRENOM DU USER");
        String libelle = scanner.nextLine();
        User retrievedUser = new User();
        for (User u: userRepository.getAll()
        ) {
            if(u.getPrenom().toLowerCase().equals(libelle.toLowerCase()))
            {
                retrievedUser = u;
            }
        }
        userRepository.deleteUser(retrievedUser);
    }
    /*********FONCTIONNALITES APPROS *****************/
    public void ajouterAppro() throws ParseException {
        Approvisionnement approvisionnement = new Approvisionnement();
        approvisionnement.setId(approRepository.getAll().length + 1);
        System.out.println("*CHOISIR UN PRODUIT ");
        displayService.afficherListeProduits(produitRepository.getAll());
        Produit produit = rechercherProduit();
        System.out.println("QUANTITE INITIALE: " + produit.getQteStock());
        approvisionnement.setQteProduitInitial(produit.getQteStock());
        System.out.println("SAISIR LA QUANTITE EN COURS");
        approvisionnement.setQteProduitEncours(Integer.parseInt(scanner.nextLine()));
        approvisionnement.setProduit((int)produit.getId());
        System.out.print("SAISIR LA DATE D APPROVISIONNEMENT: ");
        approvisionnement.setDateReception(scanner.nextLine());
        approRepository.addAppro(approvisionnement);
    }

    public Approvisionnement rechercherAppro() {
        System.out.println("SAISIR LE LIBELLE DU PRODUIT");
        String libelle = scanner.nextLine();
        Approvisionnement retrievedAppro = new Approvisionnement();
        for (Approvisionnement a: approRepository.getAll()
        ) {
            if(produitRepository.getById(a.getProduit()).getLibelle().toLowerCase().equals(libelle.toLowerCase()))
            {
                displayService.afficherAppro(a);
                retrievedAppro = a;
            }
        }

        return retrievedAppro;
    }
    /*********FONCTIONNALITES CLIENT *****************/
    public void ajouterClient() throws ParseException {
        displayService.afficherMenuChoixClient();
        System.out.println("Faites votre choix");
        int choix = Integer.parseInt(scanner.nextLine());
        switch (choix)
        {
            case 1:
                System.out.println("*ENTREPRISE");
                Entreprise entreprise = new Entreprise();
                entreprise.setId(entrepriseRepository.getAll().length + 1);
                System.out.print("SAISIR LE NOM DE L ENTREPRISE: ");
                entreprise.setNom(scanner.nextLine());
                entreprise.setNumero("ENTREPRISE_000_"+ entreprise.getId());
                System.out.print("SAISIR L ADRESSE DE L ENTREPRISE: ");
                entreprise.setAdresse(scanner.nextLine());
                System.out.print("SAISIR LE NUMERO DE TELEPHONE DE L ENTREPRISE: ");
                entreprise.setTel(scanner.nextLine());
                entrepriseRepository.addEntreprise(entreprise);
                break;
            case 2:
                System.out.println("*PERSONNE");
                Personne personne = new Personne();
                personne.setId(personneRepository.getAll().length + 1);
                System.out.print("SAISIR L EMAIL ");
                personne.setEmail(scanner.nextLine());
                System.out.print("SAISIR L ADRESSE ");
                personne.setAdresse(scanner.nextLine());
                System.out.print("SAISIR LE NOM:  ");
                personne.setNom(scanner.nextLine());
                System.out.print("SAISIR LE PRENOM:  ");
                personne.setPrenom(scanner.nextLine());
                System.out.print("SAISIR LE NUMERO DE TELEPHONE:  ");
                personne.setTel(scanner.nextLine());
                System.out.print("SAISIR LA DATE DE NAISSANCE:  (dd/MM/yyyy)");
                personne.setDatenaissance(scanner.nextLine());
                personneRepository.addPersonnne(personne);
                break;
        }
    }

    public Entreprise rechercherEntreprise() {
        System.out.println("SAISIR LE NOM DE L ENTREPRISE");
        String nom = scanner.nextLine();
        Entreprise retrievedEntreprise = new Entreprise();
        for (Entreprise e: entrepriseRepository.getAll()
        ) {
            if(e.getNom().toLowerCase().equals(nom.toLowerCase()))
            {
                displayService.afficherClient(e, null);
                retrievedEntreprise = e;
            }
        }

        return retrievedEntreprise;
    }

    public Personne rechercherPersonne() {
        System.out.println("SAISIR LE PRENOM DE LA PERSONNE");
        String prenom = scanner.nextLine();
        Personne retrievedPersonne = new Personne();
        for (Personne p: personneRepository.getAll()
        ) {
            if(p.getPrenom().toLowerCase().equals(prenom.toLowerCase()))
            {
                displayService.afficherClient(null, p);
                retrievedPersonne = p;
            }
        }

        return retrievedPersonne;
    }

    public void supprimerClient() {
        System.out.println("SAISIR LE NOM DE L'ENTREPRISE OU LE PRENOM DE LA PERSONNE");
        String recherche = scanner.nextLine();
        Personne retrievedPersonne = new Personne();
        for (Personne p: personneRepository.getAll()
        ) {
            if(p.getPrenom().toLowerCase().equals(recherche.toLowerCase()))
            {
                retrievedPersonne = p;
            }
        }
        Entreprise retrievedEntreprise = new Entreprise();
        for (Entreprise e: entrepriseRepository.getAll()
        ) {
            if(e.getNom().toLowerCase().equals(recherche.toLowerCase()))
            {
                displayService.afficherClient(e, null);
                retrievedEntreprise = e;
            }
        }
        if(retrievedEntreprise != null)
        {
            entrepriseRepository.deleteEntreprise(retrievedEntreprise);
        }

        if(retrievedPersonne != null)
        {
            personneRepository.deletePersonne(retrievedPersonne);
        }

    }
    /*********FONCTIONNALITES COMMANDE *****************/
    public void ajouterCommande() {
        displayService.afficherListeProduits(produitRepository.getAll());
        Commande commande = new Commande();
        commande.setUser(1);
        long millis=System.currentTimeMillis();
        java.util.Date date=new java.util.Date(millis);
        commande.setDateCommande(date.toString());
        System.out.println("*CHOISIR UN PRODUIT: ");
        Produit p = rechercherProduit();
        System.out.println("SAISIR LA QUANTITE: ");
        int qte;
        do {
             qte = Integer.parseInt(scanner.nextLine());
        }while (qte > p.getQteStock());
        Detail detail = new Detail();
        detail.setQuantite(qte);
        detail.setCommande((int)commande.getId());
        detail.setNumeroProduit(p.getLibelle());
        detail.setId(detailRepository.getAll().length + 1);
        commande.setNumero("COMMANDE_000_"+ commande.getId());
        commandeRepository.addCommande(commande);
        detailRepository.addDetail(detail);
    }

    public Commande rechercherCommande() {
        System.out.println("SAISIR LE NUMERO DE COMMANDE");
        String numero = scanner.nextLine();
        Commande retrievedCommande = new Commande();
        for (Commande c: commandeRepository.getAll()
        ) {
            if(c.getNumero().toLowerCase().equals(numero.toLowerCase()))
            {
                displayService.afficherCommande(c);
                retrievedCommande = c;
            }
        }

        return retrievedCommande;
    }
}
