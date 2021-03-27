package repository.jdbc;

import domain.Approvisionnement;
import domain.Commande;
import domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UserRepository;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class JdbcUserRepositoryTest {
    private JdbcUserRepository jdbcUserRepository;

    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcUserRepository = new JdbcUserRepository(dataSource);
    }
    @Test
    void getAll() {
        System.out.println("Dans la méthode get users");
        //Act
        User[] users = jdbcUserRepository.getAll();
        //Assert
        assertEquals(4, users.length, "le nombre de users doit être 3");
    }

    @Test
    void getById() {
        User user = jdbcUserRepository.getById(1);
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("aaa", user.getNumero());
    }

    @Test
    void addUser() {
        User user = new User();
        user.setId(200);
        user.setAdresse("Rufisque");
        user.setNom("Ndiaye");
        user.setPrenom("Thierno");
        user.setTelephone("773335544");
        user.setProfil(1);
        user.setPassword("passer");
        user.setLogin("admin");
        jdbcUserRepository.addUser(user);
        User retrievedUser = jdbcUserRepository.getById(200);
        assertEquals(user.getId(), retrievedUser.getId());
        jdbcUserRepository.deleteUser(jdbcUserRepository.getById(200));

    }

    @Test
    void deleteUser() {
        User user = new User();
        user.setId(200);
        user.setAdresse("Rufisque");
        user.setNom("Ndiaye");
        user.setPrenom("Thierno");
        user.setTelephone("773335544");
        user.setProfil(1);
        user.setPassword("passer");
        user.setLogin("admin");
        jdbcUserRepository.addUser(user);
        jdbcUserRepository.deleteUser(user);
        assertEquals(null, jdbcUserRepository.getById(201));

    }
}