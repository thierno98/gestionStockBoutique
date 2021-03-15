package repository;

import domain.Entreprise;

public interface EntrepriseRepository {
    Entreprise[] getAll();
    Entreprise getById(int id);
}
