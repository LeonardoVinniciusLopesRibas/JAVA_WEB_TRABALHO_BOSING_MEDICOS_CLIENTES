package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.PaisModel;

@WebService
public interface IPaisInterface {
    
    @WebMethod
    PaisModel insert (PaisModel paism) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<PaisModel> selectAll() throws SQLException, ValidacaoException;
    
    @WebMethod
    PaisModel selectById(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    PaisModel update(PaisModel paism) throws SQLException, ValidacaoException;
    
    @WebMethod 
    PaisModel desativated(PaisModel paism) throws SQLException, ValidacaoException;
    
}
