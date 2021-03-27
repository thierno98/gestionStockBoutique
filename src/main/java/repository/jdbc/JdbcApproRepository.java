package repository.jdbc;

import domain.Approvisionnement;
import domain.Produit;
import repository.ApproRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class JdbcApproRepository implements ApproRepository {
    private static DataSource dataSource;
    public JdbcApproRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    static Scanner input = new Scanner(System.in);  // Create a Scanner object
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Approvisionnement[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, nom FROM prestation";
        //mapper le résultat
        List<Approvisionnement> appros = new ArrayList<Approvisionnement>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                long _id = rs.getInt("id");
                int _qteProduitInitial = Integer.parseInt(rs.getString("qteProduitInitial"));
                int _qteProduitEnCours = Integer.parseInt(rs.getString("qteProduitEnCours"));
                String _dateReception = rs.getString("dateReception"); //format.parse(rs.getString("dateReception"));
                int _idProduit = rs.getInt("produit_id");
                //mapping retour db (relationnel) avec objet Prestation
                Approvisionnement appro = new Approvisionnement(_id, _qteProduitInitial, _qteProduitEnCours, _dateReception,
                        _idProduit);
                appros.add(appro);
            }
            return appros.toArray(new Approvisionnement[0]);

        }
        catch (SQLException e) {
            return new Approvisionnement[0];
        }
        catch (Exception ex){
            return new Approvisionnement[0];
        }
    }

    public Approvisionnement getById(int id) {
        String query = "SELECT * from approvisionnement where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                long _id = rs.getInt("id");
                int _qteProduitInitial = rs.getInt("QteProduitInitial");
                int _qteProduitEnCours = rs.getInt("QteProduitEnCours");
                System.out.println("Date : " + rs.getString("DateReception"));
                String _dateReception = rs.getString("DateReception");//new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("DateReception"));
                int _idProduit = rs.getInt("produit_id");
                //mapping retour db (relationnel) avec objet Prestation
                Approvisionnement appro = new Approvisionnement(_id, _qteProduitInitial, _qteProduitEnCours, _dateReception,
                        _idProduit);
                return appro;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void addAppro(Approvisionnement appro) {
        String query =  "INSERT INTO approvisionnement(id, DateReception, QteProduitEnCours, QteProduitInitial" +
                ",produit_id) VALUES ("+ appro.getId() +",'"+ appro.getDateReception() + "'," +
                appro.getQteProduitEncours() + ", " + appro.getQteProduitInitial()+ ", " + appro.getProduit()+" )";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAppro(Approvisionnement appro) {
        String query = "DELETE from approvisionnement where id = " + appro.getId();


        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
