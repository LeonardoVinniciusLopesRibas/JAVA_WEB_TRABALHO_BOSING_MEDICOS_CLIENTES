package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.MedicoModel;

@WebService
public interface IMedicoInterface {
    
    @WebMethod
    MedicoModel insert (MedicoModel mm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<MedicoModel> selectAll() throws SQLException, ValidacaoException;
    
    @WebMethod
    MedicoModel selectById(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    MedicoModel update(MedicoModel mm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    MedicoModel desativated(MedicoModel mm) throws SQLException, ValidacaoException;
    
}
