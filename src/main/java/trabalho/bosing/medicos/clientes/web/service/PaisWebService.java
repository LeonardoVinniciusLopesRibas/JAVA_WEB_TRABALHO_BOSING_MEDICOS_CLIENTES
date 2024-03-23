package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.IPaisInterface;
import trabalho.bosing.medicos.clientes.model.PaisModel;
import trabalho.bosing.medicos.clientes.service.PaisService;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.IPaisInterface")
public class PaisWebService implements IPaisInterface{

    PaisService paiss = new PaisService();
    
    @Override
    public PaisModel insert(PaisModel paism) throws SQLException, ValidacaoException {

        return paiss.insert(paism);

    }

    @Override
    public ArrayList<PaisModel> selectAll() throws SQLException, ValidacaoException {

        return paiss.selectAll();

    }

    @Override
    public PaisModel selectById(int id) throws SQLException, ValidacaoException {

        return paiss.selectById(id);

    }

    @Override
    public PaisModel update(PaisModel paism) throws SQLException, ValidacaoException {

        return paiss.update(paism);

    }

    @Override
    public PaisModel desativated(PaisModel paism) throws SQLException, ValidacaoException {

        return paiss.desativated(paism);
        
    }
    
}
