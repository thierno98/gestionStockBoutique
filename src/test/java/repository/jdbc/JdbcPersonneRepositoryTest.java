package repository.jdbc;

import domain.Approvisionnement;
import domain.Commande;
import domain.Personne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class JdbcPersonneRepositoryTest {
    private JdbcPersonneRepository jdbcPersonneRepository;
    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcPersonneRepository = new JdbcPersonneRepository(dataSource);
    }
    @Test
    void getAll() {
        System.out.println("Dans la méthode get personnes");
        //Act
        Personne[] personnes = jdbcPersonneRepository.getAll();
        //Assert
        assertEquals(4, personnes.length, "le nombre de personnes doit être 3");
    }

    @Test
    void getById() {
        Personne personne = jdbcPersonneRepository.getById(1);
        assertNotNull(personne);
        assertEquals(1, personne.getId());
        assertEquals("aaa", personne.getPrenom());
    }

    @Test
    void addPersonnne() throws ParseException {
        Personne personne = new Personne();
        personne.setId(200);
        personne.setEmail("thierno@gmail.com");
        personne.setAdresse("Rufisque");
        personne.setNom("Ndiaye");
        personne.setPrenom("Thierno");
        personne.setTel("773335544");
        personne.setDatenaissance("1998-03-02");
        jdbcPersonneRepository.addPersonnne(personne);
        Personne retrievedPersonne = jdbcPersonneRepository.getById(200);
        assertEquals(personne.getId(), retrievedPersonne.getId());
        jdbcPersonneRepository.deletePersonne(jdbcPersonneRepository.getById(200));

    }

    @Test
    void deletePersonne() throws ParseException {
        Personne personne = new Personne();
        personne.setId(200);
        personne.setEmail("thierno@gmail.com");
        personne.setAdresse("Rufisque");
        personne.setNom("Ndiaye");
        personne.setPrenom("Thierno");
        personne.setTel("773335544");
        personne.setDatenaissance("02/03/1998");
        jdbcPersonneRepository.addPersonnne(personne);
        jdbcPersonneRepository.deletePersonne(personne);
        assertEquals(null, jdbcPersonneRepository.getById(201));
    }
}