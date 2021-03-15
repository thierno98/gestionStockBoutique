package repository.jdbc;


import domain.Paiement;

import java.util.List;

public class JdbcPaiementRepository {

    private final DataSource dataSource;
    public JdbcPaiementRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void AddPaiement(List<Paiement> _Paiements)
    {

    }

    public void EditPaiement()
    {

    }

    public void DeletePaiement()
    {

    }

    public  void ShowAllPaiement()
    {

    }
}
