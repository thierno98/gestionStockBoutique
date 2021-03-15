package domain;

import java.util.List;

public class Produit {
    private long id;
    private String libelle;
    private int qteStock;
    private int qteMinimale;
    private int prixNormale;
    private int prixMinimal;
    private List<Detail> details;
    private List<Approvisionnement> approvisionnement;

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

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public List<Approvisionnement> getApprovisionnement() {
        return approvisionnement;
    }

    public void setApprovisionnement(List<Approvisionnement> approvisionnement) {
        this.approvisionnement = approvisionnement;
    }

    public Produit()
    {

    }
    public Produit(int _id, String _libelle, int _prixNormale)
    {
        id = _id;
        libelle = _libelle;
        prixNormale = _prixNormale;
    }
}
