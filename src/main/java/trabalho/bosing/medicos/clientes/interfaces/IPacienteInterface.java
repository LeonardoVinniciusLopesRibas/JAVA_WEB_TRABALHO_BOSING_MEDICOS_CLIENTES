package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.PacienteModel;

@WebService
public interface IPacienteInterface {
    
    @WebMethod
    PacienteModel insert (PacienteModel pm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<PacienteModel> selectAll() throws SQLException, ValidacaoException;
    
    @WebMethod
    PacienteModel selectById(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    PacienteModel update(PacienteModel pm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    PacienteModel desativated(PacienteModel pm) throws SQLException, ValidacaoException;
    
}
