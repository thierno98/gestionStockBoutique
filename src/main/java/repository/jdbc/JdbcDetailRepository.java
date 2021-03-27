package repository.jdbc;

import domain.Commande;
import domain.Detail;
import domain.Produit;
import repository.DetailRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class JdbcDetailRepository implements DetailRepository {
    private final DataSource dataSource;
    public JdbcDetailRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    Scanner input = new Scanner(System.in);  // Create a Scanner object


    public Detail[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, nom FROM prestation";
        //mapper le résultat
        List<Detail> details = new ArrayList<Detail>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                long _id = rs.getInt("id");
                String _numero = rs.getString("numero");
                String _matricule = rs.getString("matricule");
                Date _dateCommande = format.parse(rs.getString("dateReception"));
                //mapping retour db (relationnel) avec objet Prestation
                Detail detail = new Detail();
                details.add(detail);
            }
            return details.toArray(new Detail[0]);

        }
        catch (SQLException e) {
            return new Detail[0];
        }
        catch (Exception ex){
            return new Detail[0];
        }
    }

    public Detail getById(int id) {
        String query = "SELECT id, nom from client where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                int retrievedId = rs.getInt("id");
                String retrievedName = rs.getString("nom");
                Detail detail = new Detail();
                return detail;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void addDetail(Detail detail) {
        String query =  "INSERT INTO detail(id, numeroProduit, quantite, commande_id" +
                ",produit_id) VALUES ("+ detail.getId() +",'"+ detail.getNumeroProduit() + "','" +
                detail.getQuantite() + "', '" + detail.getCommande()+ "', '" + detail.getProduit()+"')";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDetail(Detail detail) {
        String query = "DELETE from detail where id = " + detail.getId();
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
