package repository;

import domain.Profil;

public interface ProfilRepository {
    Profil[] getAll();
    Profil getById(int id);
}
