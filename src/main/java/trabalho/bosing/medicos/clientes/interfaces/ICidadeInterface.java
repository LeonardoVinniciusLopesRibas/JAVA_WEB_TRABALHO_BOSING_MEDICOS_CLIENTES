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
    CidadeModel insertCidade (CidadeModel cm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<CidadeModel> selectAllCidade() throws SQLException, ValidacaoException;
    
    @WebMethod
    CidadeModel selectByIdCidade(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    CidadeModel updateCidade(CidadeModel cm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    CidadeModel desativatedCidade(CidadeModel cm) throws SQLException, ValidacaoException;
    

}
