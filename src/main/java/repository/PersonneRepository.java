package repository;


import domain.Personne;

public interface PersonneRepository {
    Personne[] getAll();
    Personne getById(int id);
}
