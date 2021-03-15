package repository.jdbc;

import domain.Profil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    void getProfilsWhenExceptionOccured(){
        System.out.println("Dans la méthode getprestation when exception occured");
        DataSource dataSource = mock(DataSource.class);
        when(dataSource.createConnection()).thenThrow(new RuntimeException("Base de données non disponible"));
        jdbcBasedProfilRepository = new JdbcProfilRepository(dataSource);
        Profil[] profils = jdbcBasedProfilRepository.getAll();
        assertEquals(0, profils.length, "le nombre de prestations doit être 0");
    }

    @Test
    void getByIdShouldReturnProfilWhenAvailable(){
        Profil profil = jdbcBasedProfilRepository.getById(1);
        assertNotNull(profil);
        assertEquals(1, profil.getId());
        assertEquals("", profil.getLibelle());
    }

    @Test
    void getByIdShouldReturnPrestationWhenAvailableNotTrivial() throws SQLException {
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);

        when(dataSource.createConnection()).thenReturn(connection);
        Statement statement = mock(Statement.class);
        when(connection.createStatement()).thenReturn(statement);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        ResultSet resultSet2 = mock(ResultSet.class);
        when(preparedStatement.executeQuery()).thenReturn(resultSet2);
        when(resultSet2.getInt(anyString())).thenReturn(5);
        when(resultSet2.getString(anyString())).thenReturn("ok");

        jdbcBasedProfilRepository = new JdbcProfilRepository(dataSource);

        Profil profil = jdbcBasedProfilRepository.getById(5);
        assertNotNull(profil);
        assertEquals(5, profil.getId());
        assertEquals("ok", profil.getLibelle());
    }
}