package repository.jdbc;

import domain.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class JdbcClientRepository {
    private final DataSource dataSource;
    public JdbcClientRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    Scanner input = new Scanner(System.in);  // Create a Scanner object

    public Client SelectClient(List<Client> _clients)
    {
        System.out.println("SAISIR LE NUMERO DU CLIENT");
        String numero = input.nextLine();
        for (Client c: _clients
             ) {
                if(c.getMatricule().equals(numero))
                {
                    return c;
                }
        }
        return null;
    }

    public Client[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, nom FROM prestation";
        //mapper le résultat
        List<Client> clients = new ArrayList<Client>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                long _id = rs.getInt("id");
                String _matricule = rs.getString("matricule");
                int _qteProduitEnCours = Integer.parseInt(rs.getString("qteProduitEnCours"));
                Date _dateReception = format.parse(rs.getString("dateReception"));
                //mapping retour db (relationnel) avec objet Prestation
                Client client = new Client (_id, _matricule, null, null, null);
                clients.add(client);
            }
            return clients.toArray(new Client[0]);

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
