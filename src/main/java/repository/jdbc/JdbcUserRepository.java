package repository.jdbc;

import domain.Commande;
import domain.Profil;
import domain.User;
import repository.UserRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class JdbcUserRepository implements UserRepository {
    private final DataSource dataSource;
    public JdbcUserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, login, password, nom, prenom, telephone adresse FROM user";
        //mapper le résultat
        List<User> users = new ArrayList<User>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                //DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                //Date dateNaissance = format.parse(rs.getString("dateReception"));
                //mapping retour db (relationnel) avec objet Prestation
                User user = new User( id, login, password, nom, null, prenom,
                        adresse, telephone, null, null, null);

                users.add(user);
            }
            return users.toArray(new User[0]);

        }
        catch (SQLException e) {
            return new User[0];
        }
        catch (Exception ex){
            return new User[0];
        }

    }

    public User getById(int id) {
        String query = "SELECT id, nom from prestation where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            String login = rs.getString("login");
            String password = rs.getString("password");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String numero = rs.getString("numero");
            String adresse = rs.getString("adresse");
            String telephone = rs.getString("telephone");
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            Date dateNaissance = format.parse(rs.getString("dateReception"));
            //mapping retour db (relationnel) avec objet Prestation
            User user = new User( id, login, password, nom, numero, prenom,
                    adresse, telephone, dateNaissance, null, null);
            return user;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
