package repository.jdbc;

import domain.Approvisionnement;
import domain.Produit;
import repository.ram.ArrayBasedProduitRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class JdbcApproRepository {
    private static DataSource dataSource;
    public JdbcApproRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    static Scanner input = new Scanner(System.in);  // Create a Scanner object

    public static void AddAppro(List<Approvisionnement> _approvisionnements, List<Produit> _produits)
    {
        Approvisionnement a = new Approvisionnement();
        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        a.setDateReception(date);
        JdbcProduitRepository jdbcProduitRepository = new JdbcProduitRepository(dataSource);
        Produit _selectedProduit =  ArrayBasedProduitRepository.SelectProduit(_produits);
        a.setQteProduitInitial(_selectedProduit.getQteStock());
        System.out.println("QUANTITE INITIAL: " + _selectedProduit.getQteStock());
        System.out.println("SAISIR LA QUANTITE EN COURS ");
        a.setQteProduitEncours(input.nextInt());
        _selectedProduit.setQteStock(a.getQteProduitEncours());
        _approvisionnements.add(a);
    }


    public  void ShowAllAppro(List<Approvisionnement> _approvisionnements)
    {
        for (Approvisionnement a: _approvisionnements
             ) {
            System.out.println("-------------------------------------");
            System.out.println("DATE APPROVISIONNEMENT: " + a.getDateReception());
            System.out.println("QUANTITE INITIAL: " + a.getQteProduitInitial());
            System.out.println("QUANTITE EN COURS "+ a.getQteProduitEncours());
            System.out.println("-------------------------------------");
        }
    }

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
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                long _id = rs.getInt("id");
                int _qteProduitInitial = Integer.parseInt(rs.getString("qteProduitInitial"));
                int _qteProduitEnCours = Integer.parseInt(rs.getString("qteProduitEnCours"));
                Date _dateReception = format.parse(rs.getString("dateReception"));
                //mapping retour db (relationnel) avec objet Prestation
                Approvisionnement appro = new Approvisionnement(_id, _qteProduitInitial, _qteProduitEnCours, _dateReception,
                        null);
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
        String query = "SELECT id, nom from prestation where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            int retrievedId = rs.getInt("id");
            String retrievedName = rs.getString("nom");
            Approvisionnement appro = new Approvisionnement();
            return appro;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


}
