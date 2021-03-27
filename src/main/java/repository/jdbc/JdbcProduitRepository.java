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
                int prixMinimale = Integer.parseInt(rs.getString("prixMinimale"));
                int qteMinimale = Integer.parseInt(rs.getString("qteMinimale"));
                int qteStock = Integer.parseInt(rs.getString("qteStock"));
                //mapping retour db (relationnel) avec objet Prestation
                Produit produit = new Produit(id, libelle, prixNormale, qteStock, qteMinimale);

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
            if(rs.next())
            {
                String libelle = rs.getString("libelle");
                int prixNormale = Integer.parseInt(rs.getString("prixNormale"));
                int prixMinimale = Integer.parseInt(rs.getString("prixMinimale"));
                int qteMinimale = Integer.parseInt(rs.getString("qteMinimale"));
                int qteStock = Integer.parseInt(rs.getString("qteStock"));
                //mapping retour db (relationnel) avec objet Prestation
                Produit produit = new Produit(id, libelle, prixNormale, qteStock, qteMinimale);
                return produit;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void addProduit(Produit produit) {
        String query =  "INSERT INTO personne(id, libelle, prixMinimal, prixNormale" +
                ",qteMinimale, qteStock) VALUES ("+ produit.getId() +",'"+ produit.getLibelle() + "','" +
                produit.getPrixMinimal() + "', '" + produit.getPrixNormale()+ "', '" + produit.getQteMinimale()+ "', '" +
                 produit.getQteStock()+"')";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduit(Produit produit) {
        String query = "DELETE from produit where id = " + produit.getId();
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
