package domain;

public class Entreprise {
    private long id;
    private String numero;
    private String nom;
    private String adresse;
    private String tel;
    private String email;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public Entreprise(long _id, String _nom, String _adresse, String _tel, String _email)
    {
        id = _id;
        nom = _nom;
        adresse = _adresse;
        tel = _tel;
        email = _email;
    }
    public Entreprise()
    {

    }
}
