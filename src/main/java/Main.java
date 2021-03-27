
import controller.ApplicationController;
import domain.*;
import repository.jdbc.JdbcEntrepriseRepository;
import repository.jdbc.JdbcPersonneRepository;
import repository.jdbc.JdbcUserRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);  // Create a Scanner object



    public static void main (String[] args) throws ParseException {

        ApplicationController applicationController = new ApplicationController();
        applicationController.process();
    }



}
