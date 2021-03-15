package domain;

import java.util.Date;
import java.util.List;

public class Facture {
    private long id;
    private String numeroFacture;
    private int montantAPayer;
    private Date dateFacture;
    private Commande commande;
    private List<Paiement> paiement;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public int getMontantAPayer() {
        return montantAPayer;
    }

    public void setMontantAPayer(int montantAPayer) {
        this.montantAPayer = montantAPayer;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public List<Paiement> getPaiement() {
        return paiement;
    }

    public void setPaiement(List<Paiement> paiement) {
        this.paiement = paiement;
    }

}
