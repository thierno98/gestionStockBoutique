package repository.jdbc;

import domain.Client;
import domain.Commande;
import domain.Detail;
import domain.User;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class JdbcCommandeRepository {
    private final DataSource dataSource;
    public JdbcCommandeRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

   /* public void AddCommande(List<Commande> _commandes, List<Client> _clients, User _user)
    {
        Commande c = new Commande();
        c.setNumero("CDE-00"+ _commandes.size());
        System.out.println("CHOISIR UN CLIENT");
        JdbcClientRepository jdbcClientRepository = new JdbcClientRepository();
        c.setClient(jdbcClientRepository.SelectClient(_clients));
        c.setUser(_user);
        //c.setDateCommande();
    }*/

    public void EditCommande()
    {

    }

    public void DeleteCommande()
    {

    }

    public  void ShowAllCommande()
    {

    }


    public Client[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, nom FROM prestation";
        //mapper le résultat
        List<Commande> commandes = new ArrayList<Commande>();

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
                Commande commande = new Commande(_id, _numero, _dateCommande, false, null, null, null, null);
                commandes.add(commande);
            }
            return commandes.toArray(new Client[0]);

        }
        catch (SQLException e) {
            return new Client[0];
        }
        catch (Exception ex){
            return new Client[0];
        }
    }

    public Client getById(int id) {
        String query = "SELECT id, nom from client where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            int retrievedId = rs.getInt("id");
            String retrievedName = rs.getString("nom");
            Client client = new Client();
            return client;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
