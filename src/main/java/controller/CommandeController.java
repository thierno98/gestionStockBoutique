package controller;

import repository.jdbc.DataSource;
import repository.jdbc.MysqlDataSource;
import service.DisplayService;
import service.MenuService;
import service.console.ConsoleDisplayService;
import service.console.ScannerMenuService;

public class CommandeController {
    private final MenuService scannerMenuService ;



    public CommandeController(){
        DataSource dataSource = new MysqlDataSource();
        scannerMenuService = new ScannerMenuService(dataSource);
    }

    public void Process()
    {
        scannerMenuService.afficherMenu();
    }
}
