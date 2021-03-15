package repository.jdbc;

import domain.Entreprise;
import domain.Facture;

import java.util.List;

public class JdbcFactureRepository {

    private final DataSource dataSource;
    public JdbcFactureRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void AddFacture(List<Facture> _factures)
    {

    }

    public void EditFacture()
    {

    }

    public void DeleteFacture()
    {

    }

    public  void ShowAllFacture()
    {

    }
}
