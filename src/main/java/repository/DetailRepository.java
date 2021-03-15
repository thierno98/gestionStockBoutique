package repository;

import domain.Commande;
import domain.Detail;

public interface DetailRepository {
    Detail[] getAll();
    Detail getById(int id);
}
