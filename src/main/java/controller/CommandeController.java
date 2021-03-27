package controller;

import repository.*;
import repository.jdbc.*;
import service.DisplayService;
import service.MenuService;
import service.console.ConsoleDisplayService;
import service.console.ScannerMenuService;

public class CommandeController {
    private final DisplayService displayService ;
    private final MenuService scannerMenuService ;
    ProduitRepository produitRepository;
    UserRepository userRepository;
    CommandeRepository commandeRepository;
    public CommandeController(){
        DataSource dataSource = new MysqlDataSource();
        produitRepository = new JdbcProduitRepository(dataSource);
        userRepository = new JdbcUserRepository(dataSource);
        commandeRepository = new JdbcCommandeRepository(dataSource);
        displayService = new ConsoleDisplayService(produitRepository);
        scannerMenuService = new ScannerMenuService(dataSource, displayService);
    }

    public void process()
    {
        int choix = -1;
        while(choix != 4)
        {
            clearConsole();
            displayService.afficherMenuCommande();
            choix = scannerMenuService.faireChoixMenu(4);
            switch(choix)
            {
                case 1:
                    clearConsole();
                    scannerMenuService.ajouterCommande();
                    break;
                case 2:
                    clearConsole();
                    displayService.afficherListeCommandes(commandeRepository.getAll());
                    scannerMenuService.flush();
                    break;
                case 3:
                    clearConsole();
                    scannerMenuService.rechercherCommande();
                    scannerMenuService.flush();
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
