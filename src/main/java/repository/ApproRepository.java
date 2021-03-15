package repository;

import domain.Approvisionnement;

public interface ApproRepository {
    Approvisionnement[] getAll();
    Approvisionnement getById(int id);
}
