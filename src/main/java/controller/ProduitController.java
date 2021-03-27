package controller;

import repository.*;
import repository.jdbc.DataSource;
import repository.jdbc.JdbcProduitRepository;
import repository.jdbc.JdbcUserRepository;
import repository.jdbc.MysqlDataSource;
import service.DisplayService;
import service.MenuService;
import service.console.ConsoleDisplayService;
import service.console.ScannerMenuService;

public class ProduitController {
    private final DisplayService displayService ;
    private final MenuService scannerMenuService ;
    ProduitRepository produitRepository;
    UserRepository userRepository;
    public ProduitController(){
        DataSource dataSource = new MysqlDataSource();
        produitRepository = new JdbcProduitRepository(dataSource);
        userRepository = new JdbcUserRepository(dataSource);
        displayService = new ConsoleDisplayService(produitRepository);
        scannerMenuService = new ScannerMenuService(dataSource, displayService);
    }

    public void process()
    {
        int choix = -1;
        while(choix != 5)
        {
            clearConsole();
            displayService.afficherMenuProduit();
            choix = scannerMenuService.faireChoixMenu(5);
            switch(choix)
            {
                case 1:
                    clearConsole();
                    scannerMenuService.ajouterProduit();
                    break;
                case 2:
                    clearConsole();
                    displayService.afficherListeProduits(produitRepository.getAll());
                    scannerMenuService.flush();
                    break;
                case 3:
                    clearConsole();
                    scannerMenuService.rechercherProduit();
                    scannerMenuService.flush();
                    break;
                case 4:
                    clearConsole();
                    scannerMenuService.supprimerProduit();
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
