package controller;

import repository.*;
import repository.jdbc.*;
import service.DisplayService;
import service.MenuService;
import service.console.ConsoleDisplayService;
import service.console.ScannerMenuService;

import java.text.ParseException;

public class ApprovisionnementController {
    private final DisplayService displayService ;
    private final MenuService scannerMenuService ;
    ProduitRepository produitRepository;
    UserRepository userRepository;
    CommandeRepository commandeRepository;
    ApproRepository approRepository;
    public ApprovisionnementController(){
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
        while(choix != 4)
        {
            clearConsole();
            displayService.afficherMenuAppro();
            choix = scannerMenuService.faireChoixMenu(4);
            switch(choix)
            {
                case 1:
                    clearConsole();
                    scannerMenuService.ajouterAppro();
                    break;
                case 2:
                    clearConsole();
                    displayService.afficherListeAppros(approRepository.getAll());
                    scannerMenuService.flush();
                    break;
                case 3:
                    clearConsole();
                    scannerMenuService.rechercherAppro();
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
