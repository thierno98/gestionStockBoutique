package repository;

import domain.Approvisionnement;
import domain.Commande;
import domain.Detail;
import domain.Produit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DetailRepository {
    Scanner input = new Scanner(System.in);  // Create a Scanner object

    public void AddDetail(List<Detail> _details, List<Produit> _produits, Commande _commande)
    {
        Detail d = new Detail();
        d.setId(_details.size() + 1);
        System.out.println("SAISIR LA QUANTITE DU PRODUIT");
        d.setQuantite(input.nextInt());
        System.out.println("CHOISIR UN PRODUIT");
        ProduitRepository produitRepository = new ProduitRepository();
        Produit _p = produitRepository.SelectProduit(_produits);
        d.setProduit(_p);
        d.setNumeroProduit(_p.getLibelle());
        d.setCommande(_commande);
    }




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
