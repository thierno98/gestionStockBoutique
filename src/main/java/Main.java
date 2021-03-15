import controller.CommandeController;
import domain.*;
import repository.jdbc.JdbcEntrepriseRepository;
import repository.jdbc.JdbcPersonneRepository;
import repository.jdbc.JdbcUserRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);  // Create a Scanner object

    public static List<Profil> m_profils = new ArrayList<Profil>()
    {
        {add(new Profil("admin"));}
        {add(new Profil("caissier"));}
        {add(new Profil("gestionnaire des ventes"));}
    };
    public static List<User> m_users = new ArrayList<User>();
    public static List<Entreprise> m_entreprises = new ArrayList<Entreprise>();
    public static List<Personne> m_personnes = new ArrayList<Personne>();
    public static List<Client> m_clients = new ArrayList<Client>();

    public static void main (String[] args) throws ParseException {
        //ShowSubMenu(ShowMainMenu());
        CommandeController commandeController = new CommandeController();
        commandeController.Process();
    }

/*
    public static int ShowMainMenu()
    {
        int choix = 0;

        while(choix != 6) {
            clearConsole();
            System.out.println("---------------------GESTION STOCK BOUTIQUE INFORMATIQUE------");
            System.out.println("1--------------------GESTION UTILISATEURS");
            System.out.println("2--------------------GESTION DES ENTREPRISES");
            System.out.println("3--------------------GESTION DES PERSONNES");
            System.out.println("3--------------------GESTION DES PRODUITS");
            System.out.println("4--------------------GESTION DES COMMANDES");
            System.out.println("5--------------------GESTION DES PAIEMENTS");
            System.out.println("6--------------------QUITTER");
            do {
                System.out.println("Faites votre choix");
                choix = input.nextInt();
            } while (choix < 1 || choix > 6);
            return choix;
        }
        return 0;
    }

    public static void ShowSubMenu(int _choix) throws ParseException {
        switch (_choix)
        {
            case 1:
                clearConsole();
                ShowGestionUtilisateurs();
                ShowSubMenu(ShowMainMenu());
                break;
            case 2:
                clearConsole();
                ShowGestionEntreprises();
                ShowSubMenu(ShowMainMenu());
                break;
            case 3:
                clearConsole();
                ShowGestionPersonnes();
                ShowSubMenu(ShowMainMenu());
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                return;

        }
    }

    public static void ShowGestionUtilisateurs() throws ParseException {

        System.out.println("---------------------GESTION UTILISATEURS------");
        System.out.println("1--------------------AJOUT UTILISATEUR");
        System.out.println("2--------------------MODIFIER UTILISATEUR");
        System.out.println("3--------------------SUPPRIMER UTILISATEUR");
        System.out.println("4--------------------AFFICHER UTILISATEURS");
        System.out.println("5--------------------RETOUR");
        System.out.println("6--------------------QUITTER");
        int choix;
        do{
            System.out.println("Faites votre choix");
            choix = input.nextInt();
        }while (choix < 1 || choix > 6);
        JdbcUserRepository jdbcUserRepository = new JdbcUserRepository();
        switch(choix)
        {
            case 1:
                jdbcUserRepository.AddUser(m_users, m_profils);
                ShowSubMenu(ShowMainMenu());
                break;
            case 2:
                jdbcUserRepository.EditUser(m_users, m_profils);
                ShowSubMenu(ShowMainMenu());
                break;
            case 3:
                jdbcUserRepository.DeleteUser(m_users);
                ShowSubMenu(ShowMainMenu());
                break;
            case 4:
                jdbcUserRepository.ShowAllUser(m_users);
                ShowSubMenu(ShowMainMenu());
                break;
            case 5:
                ShowSubMenu(ShowMainMenu());
                break;
            case 6:
                return;
        }
    }

    public static void ShowGestionEntreprises() throws ParseException {

        System.out.println("---------------------GESTION ENTREPRISE------");
        System.out.println("1--------------------AJOUT ENTREPRISE");
        System.out.println("2--------------------MODIFIER ENTREPRISE");
        System.out.println("3--------------------SUPPRIMER ENTREPRISE");
        System.out.println("4--------------------AFFICHER ENTREPRISES");
        System.out.println("5--------------------RETOUR");
        System.out.println("6--------------------QUITTER");
        int choix;
        do{
            System.out.println("Faites votre choix");
            choix = input.nextInt();
        }while (choix < 1 || choix > 6);
        JdbcEntrepriseRepository jdbcEntrepriseRepository = new JdbcEntrepriseRepository();
        switch(choix)
        {
            case 1:
                jdbcEntrepriseRepository.AddEntreprise(m_entreprises, m_clients);
                break;
            case 2:
                jdbcEntrepriseRepository.EditEntreprise(m_entreprises);
                break;
            case 3:


                break;
            case 4:
                jdbcEntrepriseRepository.ShowAllEntreprise(m_entreprises);
                break;
            case 5:
                ShowSubMenu(ShowMainMenu());
                break;
            case 6:
                return;
        }
    }

    public static void ShowGestionPersonnes() throws ParseException {

        System.out.println("---------------------GESTION PERSONNE------");
        System.out.println("1--------------------AJOUT PERSONNE");
        System.out.println("2--------------------MODIFIER PERSONNE");
        System.out.println("3--------------------SUPPRIMER PERSONNE");
        System.out.println("4--------------------AFFICHER PERSONNE");
        System.out.println("5--------------------RETOUR");
        System.out.println("6--------------------QUITTER");
        int choix;
        do{
            System.out.println("Faites votre choix");
            choix = input.nextInt();
        }while (choix < 1 || choix > 6);
        JdbcPersonneRepository jdbcPersonneRepository = new JdbcPersonneRepository();
        switch(choix)
        {
            case 1:
                jdbcPersonneRepository.AddPersonne(m_personnes);
                break;
            case 2:
                jdbcPersonneRepository.EditPersonne(m_personnes);
                break;
            case 3:
                jdbcPersonneRepository.DeletePersonne(m_personnes, m_clients);
                break;
            case 4:
                jdbcPersonneRepository.ShowAllPersonne(m_personnes);
                break;
            case 5:
                ShowSubMenu(ShowMainMenu());
                break;
            case 6:
                return;
        }
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
    }*/
}
