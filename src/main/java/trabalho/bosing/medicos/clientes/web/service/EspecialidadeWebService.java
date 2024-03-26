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
    public EspecialidadeModel insertEspecialidade(EspecialidadeModel epm) throws SQLException, ValidacaoException {

        return eps.insert(epm);
        
    }

    @Override
    public ArrayList<EspecialidadeModel> selectAllEspecialidade() throws SQLException, ValidacaoException {

        return eps.selectAll();

    }

    @Override
    public EspecialidadeModel selectByIdEspecialidade(int id) throws SQLException, ValidacaoException {

        return eps.selectById(id);
        
    }

    @Override
    public EspecialidadeModel updateEspecialidade(EspecialidadeModel epm) throws SQLException, ValidacaoException {

        return eps.update(epm);
        
    }

    @Override
    public EspecialidadeModel desativatedEspecialidade(EspecialidadeModel epm) throws SQLException, ValidacaoException {

        return eps.desativated(epm);

    }
    
}
