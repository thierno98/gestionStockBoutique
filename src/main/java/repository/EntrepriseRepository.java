package repository;

import domain.Detail;
import domain.Entreprise;

public interface EntrepriseRepository {
    Entreprise[] getAll();
    Entreprise getById(int id);
    void addEntreprise(Entreprise entreprise);
    void deleteEntreprise(Entreprise entreprise);
}
