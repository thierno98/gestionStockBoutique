package controller;

import repository.*;
import repository.jdbc.*;
import service.DisplayService;
import service.MenuService;
import service.console.ConsoleDisplayService;
import service.console.ScannerMenuService;

import java.text.ParseException;

public class ApplicationController {
    private final DisplayService displayService ;
    private final MenuService scannerMenuService ;
    ProduitRepository produitRepository;
    UserRepository userRepository;
    CommandeRepository commandeRepository;
    ApproRepository approRepository;
    ApprovisionnementController approvisionnementController = new ApprovisionnementController();
    ClientController clientController = new ClientController();
    CommandeController commandeController = new CommandeController();
    ProduitController produitController = new ProduitController();
    UserController userController = new UserController();
    public ApplicationController(){
        DataSource dataSource = new MysqlDataSource();
        produitRepository = new JdbcProduitRepository(dataSource);
        userRepository = new JdbcUserRepository(dataSource);
        commandeRepository = new JdbcCommandeRepository(dataSource);
        approRepository = new JdbcApproRepository(dataSource);
        displayService = new ConsoleDisplayService(produitRepository);
        scannerMenuService = new ScannerMenuService(dataSource, displayService);
    }

    public void process() throws ParseException {
        int choix = -1;
        while(choix != 6)
        {
            clearConsole();
            displayService.afficherMenuPrincipal();
            choix = scannerMenuService.faireChoixMenu(6);
            switch(choix)
            {
                case 1:
                    clearConsole();
                    userController.process();
                    break;
                case 2:
                    clearConsole();
                    produitController.process();
                    scannerMenuService.flush();
                    break;
                case 3:
                    clearConsole();
                    approvisionnementController.process();
                    scannerMenuService.flush();
                    break;
                case 4:
                    clearConsole();
                    clientController.process();
                    scannerMenuService.flush();
                    break;
                case 5:
                    clearConsole();
                    commandeController.process();
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
