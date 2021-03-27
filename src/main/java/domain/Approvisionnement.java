package domain;

import java.util.Date;

public class Approvisionnement {
    private long id;
    public int QteProduitInitial;
    public int QteProduitEncours;
    private String DateReception;
    private int  produit;

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

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

    public String getDateReception() {
        return DateReception;
    }

    public void setDateReception(String dateReception) {
        DateReception = dateReception;
    }



    public Approvisionnement(long _id, int _qteProduitInitial, int _qteProduitEnCours, String _dateReception,
                             int _produit)
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
