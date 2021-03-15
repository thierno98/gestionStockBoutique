package repository;

import domain.Facture;

public interface FactureRepository {
    Facture[] getAll();
    Facture getById(int id);
}
