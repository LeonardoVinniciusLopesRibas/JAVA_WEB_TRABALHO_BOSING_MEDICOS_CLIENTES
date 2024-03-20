package trabalho.bosing.medicos.clientes.infrastructure;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;

public class ConnectionFactory {

    private static final String RESOURCE_NAME = "PostgresResourcesTrabalhoBosingMedicosClientes";

    private DataSource getDataSource() throws NamingException, ValidacaoException {

        try {
            Context c = new InitialContext();

            return (DataSource) c.lookup(RESOURCE_NAME);
        } catch (NamingException ne) {
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR - PACOTE: trabalho.bosing.medicos.clientes.infrastructure");
        }
    }

    public Connection getConnection() throws ValidacaoException {
        try {
            return getDataSource().getConnection();
        } catch (Exception e) {
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR - PACOTE: trabalho.bosing.medicos.clientes.infrastructure");
        }
    }
}
