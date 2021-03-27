package repository;

import domain.Profil;
import domain.User;

public interface UserRepository {
    User[] getAll();
    User getById(int id);
    void addUser(User user);
    void deleteUser(User user);
}
