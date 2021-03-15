package domain;

public class Detail {
    private long id;
    private String numeroProduit;
    int quantite;
    private Commande commande;
    private Produit produit;

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

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
