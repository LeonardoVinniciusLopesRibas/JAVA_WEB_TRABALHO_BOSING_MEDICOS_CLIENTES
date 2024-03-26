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
    public CidadeModel insertCidade(CidadeModel cm) throws SQLException, ValidacaoException {

        return cs.insert(cm);
        
    }

    @Override
    public ArrayList<CidadeModel> selectAllCidade() throws SQLException, ValidacaoException {

        return cs.selectAll();
        
    }

    @Override
    public CidadeModel selectByIdCidade(int id) throws SQLException, ValidacaoException {

        return cs.selectById(id);
        
    }

    @Override
    public CidadeModel updateCidade(CidadeModel cm) throws SQLException, ValidacaoException {
        
        return cs.update(cm);
        
    }

    @Override
    public CidadeModel desativatedCidade(CidadeModel cm) throws SQLException, ValidacaoException {

        return cs.desativated(cm);

    }
    
}
