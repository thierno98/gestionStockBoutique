package repository.jdbc;

import domain.Commande;
import domain.Detail;
import domain.Produit;

import java.util.List;
import java.util.Scanner;

public class JdbcDetailRepository {
    private final DataSource dataSource;
    public JdbcDetailRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    Scanner input = new Scanner(System.in);  // Create a Scanner object

    /*public void AddDetail(List<Detail> _details, List<Produit> _produits, Commande _commande)
    {
        Detail d = new Detail();
        d.setId(_details.size() + 1);
        System.out.println("SAISIR LA QUANTITE DU PRODUIT");
        d.setQuantite(input.nextInt());
        System.out.println("CHOISIR UN PRODUIT");
        JdbcProduitRepository jdbcProduitRepository = new JdbcProduitRepository();
        Produit _p = jdbcProduitRepository.SelectProduit(_produits);
        d.setProduit(_p);
        d.setNumeroProduit(_p.getLibelle());
        d.setCommande(_commande);
    }*/




    public  void ShowAllDetail(List<Detail> _details)
    {
        for (Detail d: _details
             ) {
            System.out.println("LIBELLE PRODUIT: " + d.getProduit().getLibelle());
            System.out.println("QUANTITE DU PRODUIT: " + d.getQuantite());
            System.out.println("PRIX DU PRODUIT: " + d.getProduit().getPrixNormale());
        }
    }
}
