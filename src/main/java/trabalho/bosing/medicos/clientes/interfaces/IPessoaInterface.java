package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.PessoaModel;

@WebService
public interface IPessoaInterface {
    
    @WebMethod
    PessoaModel insertPessoa (PessoaModel pessm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<PessoaModel> selectAllPessoa() throws SQLException, ValidacaoException;
    
    @WebMethod
    PessoaModel selectByIdPessoa(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    PessoaModel updatePessoa(PessoaModel pessm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    PessoaModel desativatedPessoa(PessoaModel pessm) throws SQLException, ValidacaoException;
    
}
