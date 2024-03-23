package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.PaisModel;
import trabalho.bosing.medicos.clientes.model.PessoaModel;

@WebService
public interface IPessoaInterface {
    
    @WebMethod
    PessoaModel insert (PessoaModel pessm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<PessoaModel> selectAll() throws SQLException, ValidacaoException;
    
    @WebMethod
    PessoaModel selectById(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    PessoaModel update(PessoaModel pessm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    PessoaModel desativated(PessoaModel pessm) throws SQLException, ValidacaoException;
    
}
