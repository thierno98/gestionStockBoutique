package service;

import domain.Produit;
import domain.Profil;
import domain.User;

public interface DisplayService {
    void afficherBienvenue();
    void afficherMenuPrincipal();
    void afficherListeProfils(Profil[] profils);
    void afficherListeUtilisateurs(User[] users);
    void afficherListeProduits(Produit[] produits);
    void faireCommande();
}
