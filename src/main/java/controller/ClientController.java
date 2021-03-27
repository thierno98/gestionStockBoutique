package controller;

import repository.*;
import repository.jdbc.*;
import service.DisplayService;
import service.MenuService;
import service.console.ConsoleDisplayService;
import service.console.ScannerMenuService;

import java.text.ParseException;

public class ClientController {
    private final DisplayService displayService ;
    private final MenuService scannerMenuService ;
    ProduitRepository produitRepository;
    UserRepository userRepository;
    EntrepriseRepository entrepriseRepository;
    PersonneRepository personneRepository;
    public ClientController(){
        DataSource dataSource = new MysqlDataSource();
        produitRepository = new JdbcProduitRepository(dataSource);
        userRepository = new JdbcUserRepository(dataSource);
        entrepriseRepository = new JdbcEntrepriseRepository(dataSource);
        personneRepository = new JdbcPersonneRepository(dataSource);
        displayService = new ConsoleDisplayService(produitRepository);
        scannerMenuService = new ScannerMenuService(dataSource, displayService);
    }

    public void process() throws ParseException {
        int choix = -1;
        while(choix != 6)
        {
            clearConsole();
            displayService.afficherMenuClient();
            choix = scannerMenuService.faireChoixMenu(6);
            switch(choix)
            {
                case 1:
                    clearConsole();
                    scannerMenuService.ajouterClient();
                    break;
                case 2:
                    clearConsole();
                    displayService.afficherListeClients(entrepriseRepository.getAll(), personneRepository.getAll());
                    scannerMenuService.flush();
                    break;
                case 3:
                    clearConsole();
                    scannerMenuService.rechercherEntreprise();
                    scannerMenuService.flush();
                    break;
                case 4:
                    clearConsole();
                    scannerMenuService.rechercherPersonne();
                    break;
                case 5:
                    clearConsole();
                    scannerMenuService.supprimerClient();
                    break;
            }
        }
    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }
}
