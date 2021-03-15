package repository.jdbc;

import domain.Profil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JdbcProfilRepositoryTest {

    private JdbcProfilRepository jdbcBasedProfilRepository;

    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MockDatasource();
        jdbcBasedProfilRepository = new JdbcProfilRepository(dataSource);
    }
    @Test
    void getAll() {

        System.out.println("Dans la méthode get prestations");
        //Act
        Profil[] prestations = jdbcBasedProfilRepository.getAll();
        //Assert
        assertEquals(4, prestations.length, "le nombre de profils doit être 3");
    }

    @Test
    void getById() {
    }
}