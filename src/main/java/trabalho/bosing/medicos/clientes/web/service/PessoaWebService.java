package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.IPessoaInterface;
import trabalho.bosing.medicos.clientes.model.PaisModel;
import trabalho.bosing.medicos.clientes.model.PessoaModel;
import trabalho.bosing.medicos.clientes.service.PessoaService;

@WebService (endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.IPessoaInterface")
public class PessoaWebService implements IPessoaInterface{

    PessoaService ps = new PessoaService();
    
    @Override
    public PessoaModel insert(PessoaModel pessm) throws SQLException, ValidacaoException {

        return ps.insert(pessm);

    }

    @Override
    public ArrayList<PessoaModel> selectAll() throws SQLException, ValidacaoException {

        return ps.selectAll();

    }

    @Override
    public PessoaModel selectById(int id) throws SQLException, ValidacaoException {

        return ps.selectById(id);

    }

    @Override
    public PessoaModel update(PessoaModel pessm) throws SQLException, ValidacaoException {

        return ps.update(pessm);

    }

    @Override
    public PessoaModel desativated(PessoaModel pessm) throws SQLException, ValidacaoException {

        return ps.desativated(pessm);
        
    }
    
}
