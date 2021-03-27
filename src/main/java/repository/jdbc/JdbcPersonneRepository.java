package repository.jdbc;

import domain.Personne;
import domain.User;
import repository.PersonneRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class JdbcPersonneRepository implements PersonneRepository {

    private final DataSource dataSource;
    public JdbcPersonneRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    Scanner input = new Scanner(System.in);  // Create a Scanner object
    DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    public Personne[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, nom FROM prestation";
        //mapper le résultat
        List<Personne> personnes = new ArrayList<Personne>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                long _id = rs.getInt("id");
                String _adresse = rs.getString("adresse");
                String _email = rs.getString("email");
                String _dateNaissance = rs.getString("datenaissance");
                String _nom = rs.getString("nom");
                String _prenom = rs.getString("prenom");
                String _tel = rs.getString("tel");
                int  _client = rs.getInt("client_id");
                //mapping retour db (relationnel) avec objet Prestation
                Personne personne = new Personne(_id, _prenom, _nom, _tel, _email, _adresse, _dateNaissance);
                personnes.add(personne);
            }
            return personnes.toArray(new Personne[0]);

        }
        catch (SQLException e) {
            return new Personne[0];
        }
        catch (Exception ex){
            return new Personne[0];
        }
    }

    public Personne getById(int id) {
        String query = "SELECT * from personne where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                String _adresse = rs.getString("adresse");
                String _email = rs.getString("email");
                String _dateNaissance = rs.getString("datenaissance");
                String _nom = rs.getString("nom");
                String _prenom = rs.getString("prenom");
                String _tel = rs.getString("tel");
                int  _client = rs.getInt("client_id");
                //mapping retour db (relationnel) avec objet Prestation
                Personne personne = new Personne(id, _prenom, _nom, _tel, _email, _adresse, _dateNaissance);
                return personne;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void addPersonnne(Personne personne) {
        String query =  "INSERT INTO personne(id, adresse, datenaissance, email" +
                ",nom, prenom, tel) VALUES ("+ personne.getId() +",'"+ personne.getAdresse() + "','" +
                personne.getDatenaissance() + "', '" + personne.getEmail()+ "', '" + personne.getNom()+ "', '" +
                personne.getPrenom()+ "', '" +personne.getTel()+"')";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePersonne(Personne personne) {
        String query = "DELETE from personne where id = " + personne.getId();
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
