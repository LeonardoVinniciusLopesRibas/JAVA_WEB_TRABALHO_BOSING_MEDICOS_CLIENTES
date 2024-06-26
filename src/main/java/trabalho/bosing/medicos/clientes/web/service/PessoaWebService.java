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

    PessoaService pesss = new PessoaService();
    
    @Override
    public PessoaModel insertPessoa(PessoaModel pessm) throws SQLException, ValidacaoException {

        return pesss.insert(pessm);

    }

    @Override
    public ArrayList<PessoaModel> selectAllPessoa() throws SQLException, ValidacaoException {

        return pesss.selectAll();

    }

    @Override
    public PessoaModel selectByIdPessoa(int id) throws SQLException, ValidacaoException {

        return pesss.selectById(id);

    }

    @Override
    public PessoaModel updatePessoa(PessoaModel pessm) throws SQLException, ValidacaoException {

        return pesss.update(pessm);

    }

    @Override
    public PessoaModel desativatedPessoa(PessoaModel pessm) throws SQLException, ValidacaoException {

        return pesss.desativated(pessm);
        
    }
    
}
