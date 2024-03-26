package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.EstadoModel;

@WebService
public interface IEstadoInterface {
    
    @WebMethod
    EstadoModel insertEstado (EstadoModel estm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<EstadoModel> selectAllEstado() throws SQLException, ValidacaoException;
    
    @WebMethod
    EstadoModel selectByIdEstado(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    EstadoModel updateEstado(EstadoModel estm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    EstadoModel desativatedEstado(EstadoModel estm) throws SQLException, ValidacaoException;
    
}
