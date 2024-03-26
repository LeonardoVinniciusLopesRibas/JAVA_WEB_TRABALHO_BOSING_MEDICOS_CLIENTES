package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.EspecialidadeModel;

@WebService
public interface IEspecialidadeInterface {
    
    @WebMethod
    EspecialidadeModel insertEspecialidade (EspecialidadeModel epm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<EspecialidadeModel> selectAllEspecialidade() throws SQLException, ValidacaoException;
    
    @WebMethod
    EspecialidadeModel selectByIdEspecialidade(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    EspecialidadeModel updateEspecialidade(EspecialidadeModel epm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    EspecialidadeModel desativatedEspecialidade(EspecialidadeModel epm) throws SQLException, ValidacaoException;
    
}
