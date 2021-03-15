package repository;

import domain.User;

public interface UserRepository {
    User[] getAll();
    User getById(int id);
}
