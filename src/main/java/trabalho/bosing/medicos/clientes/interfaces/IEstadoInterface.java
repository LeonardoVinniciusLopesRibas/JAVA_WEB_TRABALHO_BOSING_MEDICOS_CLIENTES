package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.EstadoModel;

public interface IEstadoInterface {
    
    @WebMethod
    EstadoModel insert (EstadoModel estm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<EstadoModel> selectAll() throws SQLException, ValidacaoException;
    
    @WebMethod
    EstadoModel selectById(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    EstadoModel update(EstadoModel estm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    EstadoModel desativated(EstadoModel estm) throws SQLException, ValidacaoException;
    
}
