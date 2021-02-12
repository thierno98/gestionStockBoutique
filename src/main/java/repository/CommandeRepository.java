package repository;

import domain.Approvisionnement;
import domain.Client;
import domain.Commande;
import domain.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommandeRepository {

    public void AddCommande(List<Commande> _commandes, List<Client> _clients, User _user)
    {
        Commande c = new Commande();
        c.setNumero("CDE-00"+ _commandes.size());
        System.out.println("CHOISIR UN CLIENT");
        ClientRepository clientRepository = new ClientRepository();
        c.setClient(clientRepository.SelectClient(_clients));
        c.setUser(_user);
        //c.setDateCommande();
    }

    public void EditCommande()
    {

    }

    public void DeleteCommande()
    {

    }

    public  void ShowAllCommande()
    {

    }
}
