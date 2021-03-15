package repository;

import domain.Client;

public interface ClientRepository {
    Client[] getAll();
    Client getById(int id);
}
