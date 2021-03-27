package repository.jdbc;

import domain.Approvisionnement;
import domain.Commande;
import domain.Personne;
import domain.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class JdbcProduitRepositoryTest {
    private JdbcProduitRepository jdbcProduitRepository;
    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcProduitRepository = new JdbcProduitRepository(dataSource);
    }
    @Test
    void getAll() {
        System.out.println("Dans la méthode get produits");
        //Act
        Produit[] produits = jdbcProduitRepository.getAll();
        //Assert
        assertEquals(4, produits.length, "le nombre de produits doit être 3");
    }

    @Test
    void getById() {
        Produit produit = jdbcProduitRepository.getById(1);
        assertNotNull(produit);
        assertEquals(1, produit.getId());
        assertEquals("aaa", produit.getLibelle());
    }

    @Test
    void addProduit() {
        Produit produit = new Produit();
        produit.setId(200);
        produit.setPrixNormale(100000);
        produit.setQteMinimale(90000);
        produit.setQteMinimale(15);
        produit.setQteStock(30);
        produit.setLibelle("Laptop");
        jdbcProduitRepository.addProduit(produit);
        Produit retrievedProduit = jdbcProduitRepository.getById(200);
        assertEquals(produit.getId(), retrievedProduit.getId());
        jdbcProduitRepository.deleteProduit(jdbcProduitRepository.getById(200));

    }

    @Test
    void deleteProduit() {
        Produit produit = new Produit();
        produit.setId(201);
        produit.setPrixNormale(100000);
        produit.setQteMinimale(90000);
        produit.setQteMinimale(15);
        produit.setQteStock(30);
        produit.setLibelle("Laptop");
        jdbcProduitRepository.addProduit(produit);
        jdbcProduitRepository.deleteProduit(produit);
        assertEquals(null, jdbcProduitRepository.getById(201));
    }
}