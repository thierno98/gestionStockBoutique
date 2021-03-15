package domain;

import java.util.List;

public class Profil {
    private long id;
    private String libelle;
    private List<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Profil(String _libelle)
    {
        this.libelle = _libelle;
    }

    public Profil()
    {

    }
    public Profil(long _id, String _libelle, List<User> _users)
    {
        id = _id;
        libelle = _libelle;
        users = _users;
    }

}
