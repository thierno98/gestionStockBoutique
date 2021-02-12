package repository;

import domain.Produit;
import domain.Profil;
import domain.User;

import java.util.List;
import java.util.Scanner;

public class ProfilRepository {
    Scanner input = new Scanner(System.in);  // Create a Scanner object

    public void AddProfil(List<Produit> _profils)
    {

        Profil p = new Profil();
        p.setId(_profils.size() + 1);
        System.out.println("SAISIR LE LIBELLE DU PROFIL");
        p.setLibelle(input.nextLine());
    }

    public void EditProfil(String _libelleProfil, List<Profil> _profils)
    {
        for (Profil p: _profils
             ) {
            if(p.getLibelle().toLowerCase().equals(_libelleProfil.toLowerCase()))
            {
                System.out.println("SAISIR LE LIBELLE DU PROFIL");
                p.setLibelle(input.nextLine());
            }
        }
    }

    public void DeleteProfil(String _libelleProfil, List<Profil> _profils)
    {
        for (Profil p: _profils
        ) {
            if(p.getLibelle().toLowerCase().equals(_libelleProfil.toLowerCase()))
            {
                _profils.remove(p);
            }
        }
    }

    public  void ShowAllProfil(List<Profil> _profils)
    {

        for (Profil p: _profils
        ) {
            System.out.println("------------------------------");
            System.out.println("LIBELLE: " + p.getLibelle());
            System.out.println("------------------------------");
        }
    }

    public  Profil SelectProfil(List<Profil> _profils)
    {

        for (Profil p: _profils
        ) {
            System.out.println("------------------------------");
            System.out.println("LIBELLE: " + p.getLibelle());
            System.out.println("------------------------------");
        }
        System.out.println("SAISIR LE LIBELLE DU PROFIL");
        String libelle = input.nextLine();

        for (Profil p: _profils
        ) {
            if(p.getLibelle().toLowerCase().equals(libelle.toLowerCase()))
            {
                return p;
            }
        }
        return null;
    }
}
