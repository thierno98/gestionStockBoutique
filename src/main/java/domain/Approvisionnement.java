package domain;

import java.util.Date;

public class Approvisionnement {
    private long id;
    public int QteProduitInitial;
    public int QteProduitEncours;
    private Date DateReception;
    private Produit produit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQteProduitInitial() {
        return QteProduitInitial;
    }

    public void setQteProduitInitial(int qteProduitInitial) {
        QteProduitInitial = qteProduitInitial;
    }

    public int getQteProduitEncours() {
        return QteProduitEncours;
    }

    public void setQteProduitEncours(int qteProduitEncours) {
        QteProduitEncours = qteProduitEncours;
    }

    public Date getDateReception() {
        return DateReception;
    }

    public void setDateReception(Date dateReception) {
        DateReception = dateReception;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Approvisionnement(long _id, int _qteProduitInitial, int _qteProduitEnCours, Date _dateReception,
                             Produit _produit)
    {
        id = _id;
        QteProduitInitial = _qteProduitInitial;
        QteProduitEncours = _qteProduitEnCours;
        DateReception = _dateReception;
        produit = _produit;
    }
    public Approvisionnement()
    {
    }
}
