import com.sun.org.apache.bcel.internal.generic.SWITCH;
import domain.*;
import repository.EntrepriseRepository;
import repository.PersonneRepository;
import repository.UserRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);  // Create a Scanner object

    public static List<Profil> m_profils = new ArrayList<Profil>();
    public static List<User> m_users = new ArrayList<User>();
    public static List<Entreprise> m_entreprises = new ArrayList<Entreprise>();
    public static List<Personne> m_personnes = new ArrayList<Personne>();
    public static List<Client> m_clients = new ArrayList<Client>();

    public static void main (String[] args) throws ParseException {
        ShowSubMenu(ShowMainMenu());
    }


    public static int ShowMainMenu()
    {
        int choix = 0;

        while(choix != 6) {
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
                ShowGestionUtilisateurs();
                break;
            case 2:
                ShowGestionEntreprises();
                break;
            case 3:
                ShowGestionPersonnes();
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
        UserRepository userRepository = new UserRepository();
        switch(choix)
        {
            case 1:
                userRepository.AddUser(m_users, m_profils);
                break;
            case 2:
                userRepository.EditUser(m_users, m_profils);
                break;
            case 3:
                userRepository.DeleteUser(m_users);
                break;
            case 4:
                userRepository.ShowAllUser(m_users);
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
        EntrepriseRepository entrepriseRepository = new EntrepriseRepository();
        switch(choix)
        {
            case 1:
                entrepriseRepository.AddEntreprise(m_entreprises, m_clients);
                break;
            case 2:
                entrepriseRepository.EditEntreprise(m_entreprises);
                break;
            case 3:


                break;
            case 4:
                entrepriseRepository.ShowAllEntreprise(m_entreprises);
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
        PersonneRepository personneRepository = new PersonneRepository();
        switch(choix)
        {
            case 1:
                personneRepository.AddPersonne(m_personnes);
                break;
            case 2:
                personneRepository.EditPersonne(m_personnes);
                break;
            case 3:
                personneRepository.DeletePersonne(m_personnes, m_clients);
                break;
            case 4:
                personneRepository.ShowAllPersonne(m_personnes);
                break;
            case 5:
                ShowSubMenu(ShowMainMenu());
                break;
            case 6:
                return;
        }
    }
}
