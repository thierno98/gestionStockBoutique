package domain;

public class Detail {
    private long id;
    private String numeroProduit;
    int quantite;
    private int commande;
    private int produit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroProduit() {
        return numeroProduit;
    }

    public void setNumeroProduit(String numeroProduit) {
        this.numeroProduit = numeroProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }
}
