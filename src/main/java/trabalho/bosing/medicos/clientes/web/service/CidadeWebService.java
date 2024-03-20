package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.ICidadeInterface;
import trabalho.bosing.medicos.clientes.model.CidadeModel;
import trabalho.bosing.medicos.clientes.service.CidadeService;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.ICidadeInterface")
public class CidadeWebService implements ICidadeInterface{

    CidadeService cs = new CidadeService();

    
    @Override
    public CidadeModel insert(CidadeModel cm) throws SQLException, ValidacaoException {

        return cs.insert(cm);
        
    }

    @Override
    public ArrayList<CidadeModel> selectAll() throws SQLException, ValidacaoException {

        return cs.selectAll();
        
    }

    @Override
    public CidadeModel selectById(int id) throws SQLException, ValidacaoException {

        return cs.selectById(id);
        
    }

    @Override
    public CidadeModel update(CidadeModel cm) throws SQLException, ValidacaoException {
        
        return cs.update(cm);
        
    }

    @Override
    public CidadeModel desativated(CidadeModel cm) throws SQLException, ValidacaoException {

        return cs.desativated(cm);

    }
    
}
