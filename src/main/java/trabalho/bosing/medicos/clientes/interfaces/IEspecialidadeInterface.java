package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.EspecialidadeModel;

public interface IEspecialidadeInterface {
    
    @WebMethod
    EspecialidadeModel insert (EspecialidadeModel epm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<EspecialidadeModel> selectAll() throws SQLException, ValidacaoException;
    
    @WebMethod
    EspecialidadeModel selectById(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    EspecialidadeModel update(EspecialidadeModel epm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    EspecialidadeModel desativated(EspecialidadeModel epm) throws SQLException, ValidacaoException;
    
}
