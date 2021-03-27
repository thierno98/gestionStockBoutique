package repository.jdbc;

import domain.Approvisionnement;
import domain.Commande;
import domain.Entreprise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class JdbcEntrepriseRepositoryTest {
    private JdbcEntrepriseRepository jdbcEntrepriseRepository;
    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcEntrepriseRepository = new JdbcEntrepriseRepository(dataSource);
    }
    @Test
    void getAll() {
        System.out.println("Dans la méthode get entreprises");
        //Act
        Entreprise[] entreprises = jdbcEntrepriseRepository.getAll();
        //Assert
        assertEquals(4, entreprises.length, "le nombre d'entreprises doit être 3");
    }

    @Test
    void getById() {
        Entreprise entreprise = jdbcEntrepriseRepository.getById(1);
        assertNotNull(entreprise);
        assertEquals(1, entreprise.getId());
        assertEquals("aaa", entreprise.getNumero());
    }

    @Test
    void addEntreprise() {
        Entreprise entreprise = new Entreprise();
        entreprise.setId(200);
        entreprise.setNom("Wari");
        entreprise.setNumero("ENTREPRISE_000_"+ entreprise.getId());
        entreprise.setAdresse("Dakar");
        entreprise.setTel("336665544");
        jdbcEntrepriseRepository.addEntreprise(entreprise);
        Entreprise retrievedEntreprise = jdbcEntrepriseRepository.getById(200);
        assertEquals(entreprise.getId(), retrievedEntreprise.getId());
        jdbcEntrepriseRepository.deleteEntreprise(jdbcEntrepriseRepository.getById(200));

    }

    @Test
    void deleteEntreprise() {
        Entreprise entreprise = new Entreprise();
        entreprise.setId(200);
        entreprise.setNom("Wari");
        entreprise.setNumero("ENTREPRISE_000_"+ entreprise.getId());
        entreprise.setAdresse("Dakar");
        entreprise.setTel("336665544");
        jdbcEntrepriseRepository.addEntreprise(entreprise);
        jdbcEntrepriseRepository.deleteEntreprise(entreprise);
        assertEquals(null, jdbcEntrepriseRepository.getById(201));
    }
}