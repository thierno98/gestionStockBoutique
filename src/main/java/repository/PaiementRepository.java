package repository;

import domain.Facture;
import domain.Paiement;

public interface PaiementRepository {
    Paiement[] getAll();
    Paiement getById(int id);
}
