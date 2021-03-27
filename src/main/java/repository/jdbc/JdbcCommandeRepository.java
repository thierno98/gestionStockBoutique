package repository.jdbc;

import domain.Commande;
import domain.Detail;
import domain.User;
import repository.CommandeRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class JdbcCommandeRepository implements CommandeRepository {
    private final DataSource dataSource;
    public JdbcCommandeRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    public Commande[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, nom FROM prestation";
        //mapper le résultat
        List<Commande> commandes = new ArrayList<Commande>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                long _id = rs.getInt("id");
                String _numero = rs.getString("numero");
                int _annule = rs.getInt("annule");
                int _client = rs.getInt("client_id");
                int _user = rs.getInt("user_id");
                String _dateCommande = rs.getString("dateCommande");
                //mapping retour db (relationnel) avec objet Prestation
                Commande commande = new Commande(_id, _numero, _dateCommande, _annule, _user);
                commandes.add(commande);
            }
            return commandes.toArray(new Commande[0]);

        }
        catch (SQLException e) {
            return new Commande[0];
        }
        catch (Exception ex){
            return new Commande[0];
        }
    }

    public Commande getById(int id) {
        String query = "SELECT * from commande where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                String _numero = rs.getString("numero");
                int _annule = rs.getInt("annule");
                int _client = rs.getInt("client_id");
                int _user = rs.getInt("user_id");
                String _dateCommande = rs.getString("dateCommande");
                //mapping retour db (relationnel) avec objet Prestation
                Commande commande = new Commande(id, _numero, _dateCommande, _annule, _user);
                return commande;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void addCommande(Commande commande) {
        String query =  "INSERT INTO commande(id, annule, dateCommande, numero" +
                ", user_id) VALUES ("+ commande.getId() +","+ commande.getAnnule() + ",'" +
                commande.getDateCommande() + "', '" + commande.getNumero()+ "', " + commande.getUser()+")";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCommande(Commande commande) {
        String query = "DELETE from commande where id = " + commande.getId();
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
