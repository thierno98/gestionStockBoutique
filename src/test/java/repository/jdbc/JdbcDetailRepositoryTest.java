package repository.jdbc;

import domain.Approvisionnement;
import domain.Commande;
import domain.Detail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class JdbcDetailRepositoryTest {
    private JdbcDetailRepository jdbcDetailRepository;
    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcDetailRepository = new JdbcDetailRepository(dataSource);
    }
    @Test
    void getAll() {
        System.out.println("Dans la méthode get details");
        //Act
        Detail[] details = jdbcDetailRepository.getAll();
        //Assert
        assertEquals(4, details.length, "le nombre de détails doit être 3");
    }

    @Test
    void getById() {
        Detail detail = jdbcDetailRepository.getById(1);
        assertNotNull(detail);
        assertEquals(1, detail.getId());
        assertEquals(15, detail.getQuantite());
    }

    @Test
    void addDetail() {
        Detail detail = new Detail();
        detail.setId(200);
        detail.setNumeroProduit("PRODUIT_000_1");
        detail.setProduit(1);
        detail.setCommande(1);
        detail.setQuantite(10);
        jdbcDetailRepository.addDetail(detail);
        Detail retrievedDetail = jdbcDetailRepository.getById(200);
        assertEquals(detail.getId(), retrievedDetail.getId());

    }

    @Test
    void deleteDetail() {
        Detail detail = new Detail();
        detail.setId(201);
        detail.setNumeroProduit("PRODUIT_000_1");
        detail.setProduit(1);
        detail.setCommande(1);
        detail.setQuantite(10);
        jdbcDetailRepository.addDetail(detail);
        jdbcDetailRepository.deleteDetail(detail);
        assertEquals(null, jdbcDetailRepository.getById(201));

    }
}