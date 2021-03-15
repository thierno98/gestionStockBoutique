package repository.ram;

import domain.Profil;
import domain.User;
import repository.jdbc.DataSource;
import repository.jdbc.JdbcProfilRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ArrayBasedUserRepository {
    private final DataSource dataSource;
    public ArrayBasedUserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    Scanner input = new Scanner(System.in);  // Create a Scanner object
    public void AddUser(List<User> _users, List<Profil> _profils) throws ParseException {
        User u = new User();
        u.setId(_users.size() + 1);
        u.setNumero("USR-00" + _users.size() + 1);
        System.out.println("SAISIR L'ADRESSE DU USER");
        u.setAdresse(input.nextLine());
        u.setCommande(null);
        System.out.println("SAISIR LA DATE DE NAISSANCE DU USER (dd/MM/yyyy)");
        String date = input.nextLine();
        u.setDateNaissance(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        System.out.println("SAISIR LE LOGIN DU USER");
        u.setLogin(input.nextLine());
        System.out.println("SAISIR LE MOT DE PASSE DU USER");
        u.setPassword(input.nextLine());
        System.out.println("CHOISIR LE PROFIL DU USER");
        JdbcProfilRepository jdbcProfilRepository = new JdbcProfilRepository(dataSource);
        //u.setProfil(jdbcProfilRepository.SelectProfil(_profils));
        System.out.println("SAISIR LE NOM DU USER DU USER");
        u.setNom(input.nextLine());
        System.out.println("SAISIR LE PRENOM DU USER DU USER");
        u.setPrenom(input.nextLine());
        System.out.println("SAISIR LE TELEPHONE DU USER DU USER");
        u.setTelephone(input.nextLine());
    }

    public void EditUser(List<User> _users, List<Profil> _profils) throws ParseException {
        ShowAllUser(_users);
        System.out.println("SAISIR LE NUMERO DU USER");
        String numero = input.nextLine();
        for (User u: _users
        ) {
            if(u.getNumero().toLowerCase().equals(numero.toLowerCase()))
            {
                System.out.println("SAISIR L'ADRESSE DU USER");
                u.setAdresse(input.nextLine());
                u.setCommande(null);
                System.out.println("SAISIR LA DATE DE NAISSANCE DU USER");
                String date = input.nextLine();
                u.setDateNaissance(new SimpleDateFormat("dd/MM/yyyy").parse(date));
                System.out.println("SAISIR LE LOGIN DU USER");
                u.setLogin(input.nextLine());
                System.out.println("SAISIR LE MOT DE PASSE DU USER");
                u.setPassword(input.nextLine());
                System.out.println("CHOISIR LE PROFIL DU USER");
                JdbcProfilRepository jdbcProfilRepository = new JdbcProfilRepository(dataSource);
                //u.setProfil(jdbcProfilRepository.SelectProfil(_profils));
                System.out.println("SAISIR LE NOM DU USER DU USER");
                u.setNom(input.nextLine());
                System.out.println("SAISIR LE PRENOM DU USER DU USER");
                u.setPrenom(input.nextLine());
                System.out.println("SAISIR LE TELEPHONE DU USER DU USER");
                u.setTelephone(input.nextLine());
            }
        }

    }

    public void DeleteUser(List<User> _users)
    {
        ShowAllUser(_users);
        System.out.println("SAISIR LE NUMERO DU USER");
        String numero = input.nextLine();
        for (User u: _users
        ) {
            if(u.getNumero().toLowerCase().equals(numero.toLowerCase()))
            {
                _users.remove(u);
            }
        }

    }

    public  void ShowAllUser(List<User> _users)
    {
        for (User u: _users
        ) {
            System.out.println("-------------------------------------");
            System.out.println("NOM: " + u.getNom());
            System.out.println("PRENOM: " + u.getPrenom());
            System.out.println("DATE NAISSANCE: " + u.getDateNaissance());
            System.out.println("PROFIL: " + u.getProfil());
            System.out.println("-------------------------------------");
        }
    }
}
