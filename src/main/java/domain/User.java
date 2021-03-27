package domain;

import java.util.Date;
import java.util.List;

public class User {

    private long id;
    private String login;
    private String password;
    private String nom;
    private String numero;
    private String prenom;
    private String adresse;
    private String telephone;
    private String dateNaissance;
    private int profil;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        this.profil = profil;
    }

    public User(long _id, String _login, String _password, String _nom, String _prenom,
                String _adresse, String _telephone, String _dateNaissance, Profil _profil, List<Commande> _commande)
    {
        id = _id;
        login = _login;
        password = _password;
        nom = _nom;
        prenom = _prenom;
        adresse = _adresse;
        telephone = _telephone;
        dateNaissance = _dateNaissance;

    }

    public User()
    {

    }
}
