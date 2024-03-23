package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.IEspecialidadeInterface;
import trabalho.bosing.medicos.clientes.model.EspecialidadeModel;
import trabalho.bosing.medicos.clientes.service.EspecialidadeService;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.IEspecialidadeInterface")
public class EspecialidadeWebService implements IEspecialidadeInterface{

    EspecialidadeService eps = new EspecialidadeService();
    
    @Override
    public EspecialidadeModel insert(EspecialidadeModel epm) throws SQLException, ValidacaoException {

        return eps.insert(epm);
        
    }

    @Override
    public ArrayList<EspecialidadeModel> selectAll() throws SQLException, ValidacaoException {

        return eps.selectAll();

    }

    @Override
    public EspecialidadeModel selectById(int id) throws SQLException, ValidacaoException {

        return eps.selectById(id);
        
    }

    @Override
    public EspecialidadeModel update(EspecialidadeModel epm) throws SQLException, ValidacaoException {

        return eps.update(epm);
        
    }

    @Override
    public EspecialidadeModel desativated(EspecialidadeModel epm) throws SQLException, ValidacaoException {

        return eps.desativated(epm);

    }
    
}
