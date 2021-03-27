package domain;

import java.util.Date;

public class Personne {
    private long id;
    private String prenom;
    private String nom;
    private String tel;
    private String email;
    private String adresse;
    private String datenaissance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public Personne (long _id, String _prenom, String _nom, String _tel, String _email, String _adresse,
                   String _datenaissance)
    {
         id= _id;
        prenom = _prenom;
        nom = _nom;
        tel = _tel;
        email = _email;
        adresse = _adresse;
        datenaissance = _datenaissance;
    }

    public Personne()
    {

    }
}
