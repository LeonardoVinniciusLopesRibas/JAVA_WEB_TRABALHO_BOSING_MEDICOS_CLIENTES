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
    MedicoModel insertMedico (MedicoModel mm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<MedicoModel> selectAllMedico() throws SQLException, ValidacaoException;
    
    @WebMethod
    MedicoModel selectByIdMedico(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    MedicoModel updateMedico(MedicoModel mm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    MedicoModel desativatedMedico(MedicoModel mm) throws SQLException, ValidacaoException;
    
}
