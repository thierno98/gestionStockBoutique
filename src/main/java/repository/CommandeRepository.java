package repository;

import domain.Commande;

public interface CommandeRepository {
    Commande[] getAll();
    Commande getById(int id);
    void addCommande(Commande commande);
    void deleteCommande(Commande commande);
}
