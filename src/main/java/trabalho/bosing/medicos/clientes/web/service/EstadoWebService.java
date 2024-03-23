package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.IEstadoInterface;
import trabalho.bosing.medicos.clientes.model.EstadoModel;
import trabalho.bosing.medicos.clientes.service.EstadoService;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.IEstadoInterface")
public class EstadoWebService implements IEstadoInterface{

    EstadoService ests = new EstadoService();
    
    @Override
    public EstadoModel insert(EstadoModel estm) throws SQLException, ValidacaoException {

        return ests.insert(estm);
        
    }

    @Override
    public ArrayList<EstadoModel> selectAll() throws SQLException, ValidacaoException {

        return ests.selectAll();

    }

    @Override
    public EstadoModel selectById(int id) throws SQLException, ValidacaoException {

        return ests.selectById(id);

    }

    @Override
    public EstadoModel update(EstadoModel estm) throws SQLException, ValidacaoException {

        return ests.update(estm);

    }

    @Override
    public EstadoModel desativated(EstadoModel estm) throws SQLException, ValidacaoException {

        return ests.desativated(estm);
        
    }
    
}
