package repository;

import domain.Approvisionnement;
import domain.Produit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ApproRepository {
    Scanner input = new Scanner(System.in);  // Create a Scanner object

    public void AddAppro(List<Approvisionnement> _approvisionnements, List<Produit> _produits)
    {
        Approvisionnement a = new Approvisionnement();
        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        a.setDateReception(date);
        ProduitRepository produitRepository = new ProduitRepository();
        Produit _selectedProduit =  produitRepository.SelectProduit(_produits);
        a.setQteProduitInitial(_selectedProduit.getQteStock());
        System.out.println("QUANTITE INITIAL: " + _selectedProduit.getQteStock());
        System.out.println("SAISIR LA QUANTITE EN COURS ");
        a.setQteProduitEncours(input.nextInt());
        _selectedProduit.setQteStock(a.getQteProduitEncours());
        _approvisionnements.add(a);
    }


    public  void ShowAllAppro(List<Approvisionnement> _approvisionnements)
    {
        for (Approvisionnement a: _approvisionnements
             ) {
            System.out.println("-------------------------------------");
            System.out.println("DATE APPROVISIONNEMENT: " + a.getDateReception());
            System.out.println("QUANTITE INITIAL: " + a.getQteProduitInitial());
            System.out.println("QUANTITE EN COURS "+ a.getQteProduitEncours());
            System.out.println("-------------------------------------");
        }
    }

}
