package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.EnderecoModel;

public interface IEnderecoInterface {
    
    @WebMethod
    EnderecoModel insert (EnderecoModel em) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<EnderecoModel> selectAll() throws SQLException, ValidacaoException;
    
    @WebMethod
    EnderecoModel selectById(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    EnderecoModel update(EnderecoModel em) throws SQLException, ValidacaoException;
    
    @WebMethod 
    EnderecoModel desativated(EnderecoModel em) throws SQLException, ValidacaoException;
    
}
