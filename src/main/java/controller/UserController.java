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

public class UserController {
    private final DisplayService displayService ;
    private final MenuService scannerMenuService ;
    ProduitRepository produitRepository;
    UserRepository userRepository;
    public UserController(){
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
            displayService.afficherMenuUser();
            choix = scannerMenuService.faireChoixMenu(5);
            switch(choix)
            {
                case 1:
                    clearConsole();
                    scannerMenuService.ajouterUser();
                    break;
                case 2:
                    clearConsole();
                    displayService.afficherListeUsers(userRepository.getAll());
                    scannerMenuService.flush();
                    break;
                case 3:
                    clearConsole();
                    scannerMenuService.rechercherUser();
                    scannerMenuService.flush();
                    break;
                case 4:
                    clearConsole();
                    scannerMenuService.supprimerUser();
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
