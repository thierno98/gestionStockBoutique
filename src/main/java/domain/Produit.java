package domain;

import java.util.List;

public class Produit {
    private long id;
    private String libelle;
    private int qteStock;
    private int qteMinimale;
    private int prixNormale;
    private int prixMinimal;

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

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public int getQteMinimale() {
        return qteMinimale;
    }

    public void setQteMinimale(int qteMinimale) {
        this.qteMinimale = qteMinimale;
    }

    public int getPrixNormale() {
        return prixNormale;
    }

    public void setPrixNormale(int prixNormale) {
        this.prixNormale = prixNormale;
    }

    public int getPrixMinimal() {
        return prixMinimal;
    }

    public void setPrixMinimal(int prixMinimal) {
        this.prixMinimal = prixMinimal;
    }


    public Produit(int _id, String _libelle, int _prixNormale, int _qteStock, int _qteMinimale)
    {
        id = _id;
        libelle = _libelle;
        prixNormale = _prixNormale;
        qteStock = _qteStock;
        qteMinimale = _qteMinimale;
    }

    public Produit()
    {

    }
}
