package repository;


import domain.Entreprise;
import domain.Personne;

public interface PersonneRepository {
    Personne[] getAll();
    Personne getById(int id);
    void addPersonnne(Personne personne);
    void deletePersonne(Personne personne);
}
