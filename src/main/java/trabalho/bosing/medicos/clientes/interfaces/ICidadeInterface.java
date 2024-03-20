package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.CidadeModel;

@WebService
public interface ICidadeInterface {

    @WebMethod
    CidadeModel insert (CidadeModel cm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<CidadeModel> selectAll() throws SQLException, ValidacaoException;
    
    @WebMethod
    CidadeModel selectById(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    CidadeModel update(CidadeModel cm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    CidadeModel desativated(CidadeModel cm) throws SQLException, ValidacaoException;
    

}
