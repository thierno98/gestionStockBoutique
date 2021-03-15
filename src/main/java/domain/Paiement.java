package domain;

import java.util.Date;

public class Paiement {
    private long id;
    private String numeroPaiement;
    private int montantVerse;
    private Date dateFacture;
    private Facture facture;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroPaiement() {
        return numeroPaiement;
    }

    public void setNumeroPaiement(String numeroPaiement) {
        this.numeroPaiement = numeroPaiement;
    }

    public int getMontantVerse() {
        return montantVerse;
    }

    public void setMontantVerse(int montantVerse) {
        this.montantVerse = montantVerse;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
