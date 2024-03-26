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
    PaisModel insertPais (PaisModel paism) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<PaisModel> selectAllPais() throws SQLException, ValidacaoException;
    
    @WebMethod
    PaisModel selectByIdPais(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    PaisModel updatePais(PaisModel paism) throws SQLException, ValidacaoException;
    
    @WebMethod 
    PaisModel desativatedPais(PaisModel paism) throws SQLException, ValidacaoException;
    
}
