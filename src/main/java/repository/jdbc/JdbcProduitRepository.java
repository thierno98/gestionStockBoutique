package repository.jdbc;

import domain.Personne;
import domain.Produit;
import domain.Profil;
import repository.ProduitRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JdbcProduitRepository implements ProduitRepository {
    private final DataSource dataSource;
    public JdbcProduitRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    Scanner input = new Scanner(System.in);  // Create a Scanner object


    public Produit[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, libelle, prixNormale FROM produit";
        //mapper le résultat
        List<Produit> produits = new ArrayList<Produit>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String libelle = rs.getString("libelle");
                int prixNormale = Integer.parseInt(rs.getString("prixNormale"));
                //mapping retour db (relationnel) avec objet Prestation
                Produit produit = new Produit( id, libelle, prixNormale);

                produits.add(produit);
            }
            return produits.toArray(new Produit[0]);

        }
        catch (SQLException e) {
            return new Produit[0];
        }
        catch (Exception ex){
            return new Produit[0];
        }

    }

    public Produit getById(int id) {
        String query = "SELECT id, libelle, prixNormale from produit where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            String libelle = rs.getString("libelle");
            int prixNormale = Integer.parseInt(rs.getString("prixNormale"));
            //mapping retour db (relationnel) avec objet Prestation
            Produit produit = new Produit( id, libelle, prixNormale);
            return produit
                    ;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
