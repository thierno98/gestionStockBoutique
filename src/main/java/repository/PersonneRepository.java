package repository;

import domain.Client;
import domain.Paiement;
import domain.Personne;
import domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class PersonneRepository {

    Scanner input = new Scanner(System.in);  // Create a Scanner object

    public void AddPersonne(List<Personne> _personnes) throws ParseException {
        Personne p = new Personne();
        p.setId(_personnes.size() + 1);
        p.setNumero("PSE-00" + _personnes.size() + 1);
        System.out.println("SAISIR L'ADRESSE");
        p.setAdresse(input.nextLine());
        System.out.println("SAISIR LA DATE DE NAISSANCE ");
        String date = input.nextLine();
        p.setDatenaissance(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        System.out.println("SAISIR LE NOM");
        p.setNom(input.nextLine());
        System.out.println("SAISIR LE PRENOM");
        p.setPrenom(input.nextLine());
        System.out.println("SAISIR LE TELEPHONE");
        p.setTel(input.nextLine());
        System.out.println("SAISIR L'EMAIL");
        p.setEmail(input.nextLine());
    }

    public void EditPersonne(List<Personne> _personnnes) throws ParseException {
        System.out.println("SAISIR LE NUMERO DE LA PERSONNE");
        String numero = input.nextLine();
        for (Personne p:_personnnes
             ) {
            if(p.getNumero().toLowerCase().equals(numero.toLowerCase()))
            {
                System.out.println("SAISIR L'ADRESSE");
                p.setAdresse(input.nextLine());
                System.out.println("SAISIR LA DATE DE NAISSANCE");
                String date = input.nextLine();
                p.setDatenaissance(new SimpleDateFormat("dd/MM/yyyy").parse(date));
                System.out.println("SAISIR LE NOM");
                p.setNom(input.nextLine());
                System.out.println("SAISIR LE PRENOM");
                p.setPrenom(input.nextLine());
                System.out.println("SAISIR LE TELEPHONE ");
                p.setTel(input.nextLine());
                System.out.println("SAISIR L'EMAIL");
                p.setEmail(input.nextLine());
            }
        }
    }

    public void DeletePersonne(List<Personne> _personnnes, List<Client> _clients)
    {
        System.out.println("SAISIR LE NUMERO DE LA PERSONNE");
        String numero = input.nextLine();
        for (Personne p:_personnnes
        ) {
            if(p.getNumero().toLowerCase().equals(numero.toLowerCase()))
            {
                DeleteClient(p.getNumero(), _clients);
                _personnnes.remove(p);
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

    public  void ShowAllPersonne(List<Personne> _personnnes)
    {

        System.out.println("SAISIR LE NUMERO DE LA PERSONNE");
        String numero = input.nextLine();
        for (Personne p:_personnnes
        ) {
            System.out.println("ADRESSE PERSONNE: " + p.getAdresse());
            System.out.println("DATE DE NAISSANCE PERSONNE: " + p.getDatenaissance());
            System.out.println("NOM PERSONNE: " + p.getNom());
            System.out.println("PRENOM PERSONNE" + p.getPrenom());
            System.out.println("TELEPHONE PERSONNE" + p.getTel());
            System.out.println("EMAIL PERSONNE" + p.getEmail());
        }
    }
}
