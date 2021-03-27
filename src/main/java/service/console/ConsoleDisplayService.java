package service.console;

import domain.*;
import repository.ProduitRepository;
import service.DisplayService;

public class ConsoleDisplayService implements DisplayService {
    private final ProduitRepository produitRepository;

    public ConsoleDisplayService(ProduitRepository produitRepository)
    {
        this.produitRepository = produitRepository;
    }
    /************ MENU *****************************/
    public void afficherMenuPrincipal() {
        System.out.println("************************MENU PRINCIPAL **************************");
        System.out.println("*1.*********************GESTION DES UTILISATEURS*****************");
        System.out.println("*2.*********************GESTION DES PRODUITS*********************");
        System.out.println("*3.*********************GESTION DE L'APPROVISIONNEMENT***********");
        System.out.println("*4.*********************GESTION DES CLIENTS**********************");
        System.out.println("*5.*********************GESTION DES COMMANDES********************");
        System.out.println("*6.*********************QUITTER**********************************");

    }

    public void afficherMenuProduit() {
        System.out.println("************************MENU PRODUIT **************************");
        System.out.println("*1.*********************AJOUT PRODUIT**************************");
        System.out.println("*2.*********************LISTE PRODUITS*************************");
        System.out.println("*3.*********************RECHERCHER PRODUIT*********************");
        System.out.println("*4.*********************SUPPRIMER PRODUIT**********************");
        System.out.println("*5.*********************RETOUR**********************************");
    }

    public void afficherMenuUser() {
        System.out.println("************************MENU USER **************************");
        System.out.println("*1.*********************AJOUT USER**************************");
        System.out.println("*2.*********************LISTE USERS*************************");
        System.out.println("*3.*********************RECHERCHER USER*********************");
        System.out.println("*4.*********************SUPPRIMER USER**********************");
        System.out.println("*5.*********************RETOUR******************************");
    }

    public void afficherMenuAppro() {
        System.out.println("**************MENU APPROVISIONNEMENT ************************");
        System.out.println("*1.*********************AJOUT APPRO**************************");
        System.out.println("*2.*********************LISTE APPROVISIONNEMENTS*************");
        System.out.println("*3.*********************RECHERCHER APPRO*********************");
        System.out.println("*4.*********************RETOUR**********************************");
    }

    public void afficherMenuClient() {
        System.out.println("************************MENU CLIENT ************************");
        System.out.println("*1.*********************AJOUT CLIENT************************");
        System.out.println("*2.*********************LISTE CLIENTS***********************");
        System.out.println("*3.*********************RECHERCHER ENTRREPRISE**************");
        System.out.println("*4.*********************RECHERCHER PERSONNE*****************");
        System.out.println("*5.*********************SUPPRIMER CLIENT********************");
        System.out.println("*6.*********************RETOUR******************************");
    }

    public void afficherMenuChoixClient() {
        System.out.println("**********************************************************");
        System.out.println("*1.*********************ENTREPRISE************************");
        System.out.println("*2.*********************PERSONNE**************************");
        System.out.println("**********************************************************");
    }

    public void afficherMenuCommande() {
        System.out.println("************************MENU COMMANDE ************************");
        System.out.println("*1.*********************AJOUT COMMANDE************************");
        System.out.println("*2.*********************LISTE COMMANDES***********************");
        System.out.println("*3.*********************RECHERCHER COMMANDE*******************");
        System.out.println("*4.*********************RETOUR********************************");
    }

    public void afficherListeProduits(Produit[] produits) {
        for (Produit p :produits
             ) {
            afficherProduit(p);
        }
    }

    public void afficherProduit(Produit produit) {
            System.out.println("****************************************************");
            System.out.println("LIBELLE: " + produit.getLibelle());
            System.out.println("QTE STOCK: " + produit.getQteStock());
            System.out.println("QTE MINIMALE: " + produit.getQteMinimale());
            System.out.println("PRIX NORMALE: " + produit.getPrixNormale());
            System.out.println("PRIX MINIMAL: " + produit.getPrixMinimal());
            System.out.println("****************************************************");
    }

    public void afficherListeAppros(Approvisionnement[] appros) {
        for (Approvisionnement a: appros
             ) {
            afficherAppro(a);
        }
    }

    public void afficherAppro(Approvisionnement appro) {
        System.out.println("****************************************************");
        System.out.println("LIBELLE: " +  produitRepository.getById(appro.getProduit()).getLibelle());
        System.out.println("QTE INITIALE: " + appro.getQteProduitInitial());
        System.out.println("QTE EN COURS: " + appro.getQteProduitEncours());
        System.out.println("DATE RECEPTION: " + appro.getDateReception());
        System.out.println("****************************************************");
    }

    public void afficherListeClients(Entreprise[] entreprises, Personne[] personnes) {
        for (Entreprise e: entreprises
             ) {
            afficherClient(e, null);
        }
        for (Personne p: personnes
             ) {
            afficherClient(null, p);
        }
    }

    public void afficherClient(Entreprise entreprise, Personne personne) {
        if(entreprise != null)
        {
            System.out.println("****************************************************");
            System.out.println("**************ENTREPRISE****************************");
            System.out.println("NUMERO: " + entreprise.getNumero());
            System.out.println("NOM: " + entreprise.getNom());
            System.out.println("TEL: " + entreprise.getTel());
            System.out.println("EMAIL: " + entreprise.getEmail());
            System.out.println("ADRESSE: " + entreprise.getAdresse());
            System.out.println("****************************************************");
        }else{
            System.out.println("****************************************************");
            System.out.println("**************PERSONNE****************************");
            System.out.println("PRENOM: " + personne.getPrenom());
            System.out.println("NOM: " + personne.getNom());
            System.out.println("TEL: " + personne.getTel());
            System.out.println("EMAIL: " + personne.getEmail());
            System.out.println("ADRESSE: " + personne.getAdresse());
            System.out.println("DATE DE NAISSANCE: " + personne.getDatenaissance());
            System.out.println("****************************************************");
        }
    }

    public void afficherListeCommandes(Commande[] commandes) {
        for (Commande c: commandes
             ) {
            afficherCommande(c);
        }

    }

    public void afficherCommande(Commande commande) {
        System.out.println("****************************************************");
        System.out.println("NUMERO: " + commande.getNumero());
        System.out.println("DATE COMMANDE: " + commande.getDateCommande());
        System.out.println("****************************************************");
    }

    public void afficherListeDetails(Detail[] details) {
        for (Detail d: details
             ) {
            afficherDetail(d);
        }
    }

    public void afficherDetail(Detail detail) {
        System.out.println("****************************************************");
        System.out.println("Numero produit: " + produitRepository.getById(detail.getProduit()).getLibelle());
        System.out.println("LIBELLE: " + detail.getProduit());
        System.out.println("QUANTITE COMMANDEE: " + detail.getQuantite());
        System.out.println("****************************************************");
    }

    public void afficherListeUsers(User[] users) {
        for (User u: users
             ) {
            afficherUser(u);
        }
    }

    public void afficherUser(User user) {
        System.out.println("****************************************************");
        System.out.println("PRENOM: " + user.getPrenom());
        System.out.println("NOM: " + user.getNom());
        System.out.println("TEL: " + user.getTelephone());
        System.out.println("PROFIL: " + user.getProfil());
        System.out.println("ADRESSE: " + user.getAdresse());
        System.out.println("DATE DE NAISSANCE: " + user.getDateNaissance());
        System.out.println("****************************************************");
    }
}
