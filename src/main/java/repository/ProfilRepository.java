package repository;

import domain.Produit;
import domain.Profil;

public interface ProfilRepository {
    Profil[] getAll();
    Profil getById(int id);
    void addProfil(Profil profil);
    void deleteProfil(Profil profil);
}
