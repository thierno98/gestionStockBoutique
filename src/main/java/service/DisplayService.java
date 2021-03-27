package service;

import domain.*;

public interface DisplayService {
    /**********GESTION MENU ***********/
    void afficherMenuPrincipal();
    void afficherMenuProduit();
    void afficherMenuUser();
    void afficherMenuAppro();
    void afficherMenuClient();
    void afficherMenuChoixClient();
    void afficherMenuCommande();

    /*********FONCTIONNALITES PRODUITS *******/
    void afficherListeProduits(Produit[] produits);
    void afficherProduit(Produit produit);
    /*********FONCTIONNALITES Appro *******/
    void afficherListeAppros(Approvisionnement[] appros);
    void afficherAppro(Approvisionnement appro);
    /*********FONCTIONNALITES CLIENT *******/
    void afficherListeClients(Entreprise[] entreprises, Personne[] personnes);
    void afficherClient(Entreprise entreprise, Personne personne);
    /*********FONCTIONNALITES COMMANDE *******/
    void afficherListeCommandes(Commande[] commandes);
    void afficherCommande(Commande commande);
    /*********FONCTIONNALITES DETAILS *******/
    void afficherListeDetails(Detail[] details);
    void afficherDetail(Detail detail);
    /*********FONCTIONNALITES USER *******/
    void afficherListeUsers(User[] users);
    void afficherUser(User user);
}
