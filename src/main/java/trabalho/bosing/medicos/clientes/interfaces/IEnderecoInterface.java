package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.EnderecoModel;

@WebService
public interface IEnderecoInterface {
    
    @WebMethod
    EnderecoModel insertEndereco (EnderecoModel em) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<EnderecoModel> selectAllEndereco() throws SQLException, ValidacaoException;
    
    @WebMethod
    EnderecoModel selectByIdEndereco(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    EnderecoModel updateEndereco(EnderecoModel em) throws SQLException, ValidacaoException;
    
    @WebMethod 
    EnderecoModel desativatedEndereco(EnderecoModel em) throws SQLException, ValidacaoException;
    
}
