package repository;

import domain.Approvisionnement;
import domain.Client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ClientRepository {
    Scanner input = new Scanner(System.in);  // Create a Scanner object


    public  void ShowAllClient()
    {

    }

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
}
