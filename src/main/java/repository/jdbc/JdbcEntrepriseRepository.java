package repository.jdbc;

import domain.*;
import repository.EntrepriseRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class JdbcEntrepriseRepository implements EntrepriseRepository {

    private final DataSource dataSource;
    public JdbcEntrepriseRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    Scanner input = new Scanner(System.in);  // Create a Scanner object


    public Entreprise[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, nom FROM prestation";
        //mapper le résultat
        List<Entreprise> entreprises = new ArrayList<Entreprise>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                long _id = rs.getInt("id");
                String _adresse = rs.getString("adresse");
                String _email = rs.getString("email");
                String _nom = rs.getString("nom");
                String _tel = rs.getString("tel");
                int _client = rs.getInt("client_id");
                //mapping retour db (relationnel) avec objet Prestation
                Entreprise entreprise = new Entreprise(_id, _nom, _adresse, _tel, _email);
                entreprises.add(entreprise);
            }
            return entreprises.toArray(new Entreprise[0]);

        }
        catch (SQLException e) {
            return new Entreprise[0];
        }
        catch (Exception ex){
            return new Entreprise[0];
        }
    }

    public Entreprise getById(int id) {
        String query = "SELECT id, nom from client where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                String _adresse = rs.getString("adresse");
                String _email = rs.getString("email");
                String _nom = rs.getString("nom");
                String _tel = rs.getString("tel");
                int _client = rs.getInt("client_id");
                //mapping retour db (relationnel) avec objet Prestation
                Entreprise entreprise = new Entreprise(id, _nom, _adresse, _tel, _email);
                return entreprise;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void addEntreprise(Entreprise entreprise) {
        String query =  "INSERT INTO entreprise(id, adresse, email, nom" +
                ",tel) VALUES ("+ entreprise.getId() +",'"+ entreprise.getAdresse() + "','" +
                entreprise.getEmail() + "', '" + entreprise.getNom()+ "', '" + entreprise.getTel()+"')";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEntreprise(Entreprise entreprise) {
        String query = "DELETE from entreprise where id = " + entreprise.getId();
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
