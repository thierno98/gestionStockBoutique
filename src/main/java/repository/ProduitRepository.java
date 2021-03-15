package repository;

import domain.Personne;
import domain.Produit;

public interface ProduitRepository {
    Produit[] getAll();
    Produit getById(int id);
}
