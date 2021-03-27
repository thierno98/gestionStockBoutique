package repository.jdbc;

import domain.Approvisionnement;
import domain.Commande;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class JdbcCommandeRepositoryTest {
    private JdbcCommandeRepository jdbcCommandeRepository;
    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcCommandeRepository = new JdbcCommandeRepository(dataSource);
    }
    @Test
    void getAll() {
        System.out.println("Dans la méthode get commandes");
        //Act
        Commande[] commandes = jdbcCommandeRepository.getAll();
        //Assert
        assertEquals(4, commandes.length, "le nombre de commande doit être 3");
    }

    @Test
    void getById() {
        Commande commande = jdbcCommandeRepository.getById(1);
        assertNotNull(commande);
        assertEquals(1, commande.getId());
        assertEquals("aaa", commande.getNumero());
    }

    @Test
    void addCommande() throws ParseException {
        Commande commande = new Commande();
        commande.setId(200);
        commande.setNumero("COMMANDE_000_"+ commande.getId());
        commande.setAnnule(0);
        commande.setUser(1);
        commande.setDateCommande("10/03/2021");
        jdbcCommandeRepository.addCommande(commande);
        Commande retrievedCommande = jdbcCommandeRepository.getById(200);
        assertEquals(commande.getId(), retrievedCommande.getId());
        jdbcCommandeRepository.deleteCommande(jdbcCommandeRepository.getById(200));

    }

    @Test
    void deleteCommande() throws ParseException {
        Commande commande = new Commande();
        commande.setId(201);
        commande.setNumero("COMMANDE_000_"+ commande.getId());
        commande.setAnnule(0);
        commande.setUser(1);
        commande.setDateCommande("10/03/2021");
        jdbcCommandeRepository.addCommande(commande);
        jdbcCommandeRepository.deleteCommande(commande);
        assertEquals(null, jdbcCommandeRepository.getById(201));
    }
}