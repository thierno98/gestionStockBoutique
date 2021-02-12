package repository;

import domain.Personne;
import domain.Produit;

import java.util.List;
import java.util.Scanner;

public class ProduitRepository {
    Scanner input = new Scanner(System.in);  // Create a Scanner object

    public void AddProduit(List<Produit> _produits)
    {
        Produit p = new Produit();
        p.setId(_produits.size() + 1);
        System.out.println("SAISIR LE LIBELLE DU PRODUIT");
        p.setLibelle(input.nextLine());
        System.out.println("SAISIR LE PRIX MINIMAL DU PRODUIT");
        p.setPrixMinimal(input.nextInt());
        System.out.println("SAISIR LE PRIX NORMALE ");
        p.setPrixNormale(input.nextInt());
        System.out.println("SAISIR LA QUANTITE MINIMALE");
        p.setQteMinimale(input.nextInt());
        System.out.println("SAISIR LA QUANTITE EN STOCK");
        p.setQteStock(input.nextInt());
    }

    public void EditProduit(List<Produit> _produits)
    {
        System.out.println("SAISIR LE LIBELLE DU PRODUIT");
        String libelle = input.nextLine();
        for (Produit p: _produits
             ) {
            if(p.getLibelle().toLowerCase().equals(libelle.toLowerCase()))
            {
                System.out.println("SAISIR LE LIBELLE DU PRODUIT");
                p.setLibelle(input.nextLine());
                System.out.println("SAISIR LE PRIX MINIMAL DU PRODUIT");
                p.setPrixMinimal(input.nextInt());
                System.out.println("SAISIR LE PRIX NORMALE ");
                p.setPrixNormale(input.nextInt());
                System.out.println("SAISIR LA QUANTITE MINIMALE");
                p.setQteMinimale(input.nextInt());
                System.out.println("SAISIR LA QUANTITE EN STOCK");
                p.setQteStock(input.nextInt());
            }
        }
    }

    public void DeleteProduit(List<Produit> _produits)
    {
        System.out.println("SAISIR LE LIBELLE DU PRODUIT");
        String libelle = input.nextLine();
        for (Produit p: _produits
        ) {
            if(p.getLibelle().toLowerCase().equals(libelle.toLowerCase()))
            {
               _produits.remove(p);
            }
        }

    }

    public  void ShowAllProduit(List<Produit> _produits)
    {

        System.out.println("SAISIR LE LIBELLE DU PRODUIT");
        String libelle = input.nextLine();
        for (Produit p: _produits
        ) {
            System.out.println("-----------------------------------");
            System.out.println("LIBELLE PRDODUIT: " + p.getLibelle());
            System.out.println("PRIX MINIMAL PRODUIT: " + p.getQteMinimale());
            System.out.println("PRIX NORMALE: " + p.getPrixNormale());
            System.out.println("QUANTITE MINIMALE: " + p.getQteMinimale());
            System.out.println("QUANTITE EN STOCK: " + p.getQteStock());
            System.out.println("-----------------------------------");
        }
    }

    public Produit SelectProduit(List<Produit> _produits)
    {
        ShowAllProduit(_produits);
        System.out.println("CHOISIR UN PRODUIT PAR LIBELLE:");
        String libelle = input.nextLine();
        for (Produit p: _produits
             ) {
            if(p.getLibelle().toLowerCase().equals(libelle.toLowerCase()))
            {
                return p;
            }
        }
        return  null;
    }
}
