package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.IPacienteInterface;
import trabalho.bosing.medicos.clientes.model.PacienteModel;
import trabalho.bosing.medicos.clientes.service.PacienteService;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.IPacienteInterface")
public class PacienteWebService implements IPacienteInterface{

    PacienteService ps = new PacienteService();
    
    @Override
    public PacienteModel insert(PacienteModel pm) throws SQLException, ValidacaoException {

        return ps.insert(pm);

    }

    @Override
    public ArrayList<PacienteModel> selectAll() throws SQLException, ValidacaoException {

        return ps.selectAll();

    }

    @Override
    public PacienteModel selectById(int id) throws SQLException, ValidacaoException {

        return ps.selectById(id);

    }

    @Override
    public PacienteModel update(PacienteModel pm) throws SQLException, ValidacaoException {

        return ps.update(pm);
        
    }

    @Override
    public PacienteModel desativated(PacienteModel pm) throws SQLException, ValidacaoException {

        return ps.desativated(pm);
        
    }
    
}
