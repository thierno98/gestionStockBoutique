package repository.jdbc;

import domain.Approvisionnement;
import domain.Profil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class JdbcApproRepositoryTest {
    private JdbcApproRepository jdbcApproRepository;

    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcApproRepository = new JdbcApproRepository(dataSource);

    }
    @Test
    void getAll() {
        System.out.println("Dans la méthode get approvisionnements");
        //Act
        Approvisionnement[] appros = jdbcApproRepository.getAll();
        //Assert
        assertEquals(4, appros.length, "le nombre d'appro doit être 3");
    }

    @Test
    void getById() {
        Approvisionnement appro = jdbcApproRepository.getById(1);
        assertNotNull(appro);
        assertEquals(1, appro.getId());
        assertEquals(1, appro.getProduit());
    }

    @Test
    void addAppro() throws ParseException {
        Approvisionnement approvisionnement = new Approvisionnement();
        approvisionnement.setId(200);
        approvisionnement.setQteProduitEncours(10);
        approvisionnement.setQteProduitInitial(5);
        approvisionnement.setProduit(1);
        String date = "2021-02-02";//new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-02");
        approvisionnement.setDateReception(date);
        jdbcApproRepository.addAppro(approvisionnement);
        Approvisionnement retrievedAppro = jdbcApproRepository.getById(200);
        assertEquals(approvisionnement.getId(), retrievedAppro.getId());
        jdbcApproRepository.deleteAppro(jdbcApproRepository.getById(200));

    }

    @Test
    void deleteAppro() throws ParseException {
        Approvisionnement approvisionnement = new Approvisionnement();
        approvisionnement.setId(201);
        approvisionnement.setQteProduitEncours(10);
        approvisionnement.setQteProduitInitial(5);
        approvisionnement.setProduit(1);
        approvisionnement.setDateReception("2021-03-10"/*new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).parse("2021-03-10")*/);
        jdbcApproRepository.addAppro(approvisionnement);
        jdbcApproRepository.deleteAppro(approvisionnement);
        assertEquals(null, jdbcApproRepository.getById(201));
    }
}