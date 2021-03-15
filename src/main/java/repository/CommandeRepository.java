package repository;

import domain.Commande;

public interface CommandeRepository {
    Commande[] getAll();
    Commande getById(int id);
}
