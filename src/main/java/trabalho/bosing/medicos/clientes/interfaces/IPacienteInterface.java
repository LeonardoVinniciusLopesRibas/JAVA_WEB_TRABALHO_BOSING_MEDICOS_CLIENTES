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
    PacienteModel insertPaciente (PacienteModel pm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<PacienteModel> selectAllPaciente() throws SQLException, ValidacaoException;
    
    @WebMethod
    PacienteModel selectByIdPaciente(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    PacienteModel updatePaciente(PacienteModel pm) throws SQLException, ValidacaoException;
    
    @WebMethod 
    PacienteModel desativatedPaciente(PacienteModel pm) throws SQLException, ValidacaoException;
    
}
