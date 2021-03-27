package domain;

import java.util.Date;
import java.util.List;

public class Commande {
    private long id;
    private String numero;
    private String dateCommande;
    private int annule;
    private int user;

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

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getAnnule() {
        return annule;
    }

    public void setAnnule(int annule) {
        this.annule = annule;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Commande(long _id, String _numero, String _dateCommande, int _annule, int _user)
    {
        id = _id;
        numero = _numero;
        dateCommande = _dateCommande;
        annule =_annule;
        user = _user;
    }

    public Commande()
    {

    }
}
