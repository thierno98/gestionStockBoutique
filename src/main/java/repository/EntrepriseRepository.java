package repository;

import domain.Approvisionnement;
import domain.Client;
import domain.Entreprise;
import domain.Personne;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EntrepriseRepository {
    Scanner input = new Scanner(System.in);  // Create a Scanner object


    public void AddEntreprise(List<Entreprise> _entreprises, List<Client> _clients)
    {
        Entreprise e = new Entreprise();
        e.setId(_entreprises.size() + 1);
        e.setNumero("PSE-00" + _entreprises.size() + 1);
        System.out.println("SAISIR L'ADRESSE");
        e.setAdresse(input.nextLine());
        System.out.println("SAISIR LE NOM");
        e.setNom(input.nextLine());
        System.out.println("SAISIR LE TELEPHONE");
        e.setTel(input.nextLine());
        System.out.println("SAISIR L'EMAIL");
        e.setEmail(input.nextLine());
        Client c = new Client();
        c.setMatricule(e.getNumero());
        c.setEntreprise(e);
        _clients.add(c);
    }

    public void EditEntreprise(List<Entreprise> _entreprises)
    {

        System.out.println("SAISIR LE NUMERO DE L'ENTREPRISE");
        String numero = input.nextLine();
        for (Entreprise e:_entreprises
        ) {
            if(e.getNumero().toLowerCase().equals(numero.toLowerCase()))
            {
                System.out.println("SAISIR L'ADRESSE");
                e.setAdresse(input.nextLine());
                System.out.println("SAISIR LE NOM");
                e.setNom(input.nextLine());
                System.out.println("SAISIR LE TELEPHONE");
                e.setTel(input.nextLine());
                System.out.println("SAISIR L'EMAIL");
                e.setEmail(input.nextLine());
            }
        }
    }

    public void DeletesEntreprise(List<Entreprise> _entreprises, List<Client> _clients)
    {

        System.out.println("SAISIR LE NUMERO DE L'ENTREPRISE");
        String numero = input.nextLine();
        for (Entreprise e:_entreprises
        ) {
            if(e.getNumero().toLowerCase().equals(numero.toLowerCase()))
            {
                DeleteClient(e.getNumero(), _clients);
                _entreprises.remove(e);
            }
        }
    }

    public void DeleteClient(String _numero, List<Client> _clients)
    {
        for (Client c: _clients
             ) {
            if(c.getMatricule().toLowerCase().equals(_numero.toLowerCase()))
            {
                _clients.remove(c);
            }
        }
    }

    public  void ShowAllEntreprise(List<Entreprise> _entreprises)
    {

        System.out.println("SAISIR LE NUMERO DE L'ENTREPRISE");
        String numero = input.nextLine();
        for (Entreprise e:_entreprises
        ) {
            System.out.println("ADRESSE: " + e.getAdresse());
            System.out.println("NOM: " + e.getNom());
            System.out.println("TELEPHONE: " + e.getTel());
            System.out.println("EMAIL: " + e.getEmail());
        }
    }
}
