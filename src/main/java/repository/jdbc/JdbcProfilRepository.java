package repository.jdbc;

import domain.Produit;
import domain.Profil;
import domain.User;
import repository.ProfilRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class JdbcProfilRepository implements ProfilRepository {

    private final DataSource dataSource;
    public JdbcProfilRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Profil[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, libelle FROM profil";
        //mapper le résultat
        List<Profil> profils = new ArrayList<Profil>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String libelle = rs.getString("libelle");
                //mapping retour db (relationnel) avec objet Prestation
                Profil profil = new Profil( id, libelle, null);

                profils.add(profil);
            }
            return profils.toArray(new Profil[0]);

        }
        catch (SQLException e) {
            return new Profil[0];
        }
        catch (Exception ex){
            return new Profil[0];
        }

    }

    public Profil getById(int id) {
        String query = "SELECT id, nom from profil where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                String libelle = rs.getString("libelle");
                //mapping retour db (relationnel) avec objet Prestation
                Profil profil = new Profil( id, libelle, null);
                return profil;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void addProfil(Profil profil) {
        String query =  "INSERT INTO profil(id, libelle) VALUES ("+ profil.getId() +",'"+ profil.getLibelle()+"')";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProfil(Profil profil) {
        String query = "DELETE from produit where id = " + profil.getId();
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
