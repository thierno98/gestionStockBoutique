package service;

import domain.*;

import java.text.ParseException;

public interface MenuService {
    /************FONCTIONNALITES MENU **********/
    public int faireChoixMenu(int max);
    void flush();
    /************ FONCTIONNALITES PRODUIT **************/
    void ajouterProduit();
    Produit rechercherProduit();
    void supprimerProduit();
    /************ FONCTIONNALITES USER **************/
    void ajouterUser();
    User rechercherUser();
    void supprimerUser();
    /************ FONCTIONNALITES APPRO **************/
    void ajouterAppro() throws ParseException;
    Approvisionnement rechercherAppro();
    /************ FONCTIONNALITES CLIENT **************/
    void ajouterClient() throws ParseException;
    Entreprise rechercherEntreprise();
    Personne rechercherPersonne();
    void supprimerClient();
    /************ FONCTIONNALITES COMMANDE **************/
    void ajouterCommande();
    Commande rechercherCommande();
}
