package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.IEnderecoInterface;
import trabalho.bosing.medicos.clientes.model.EnderecoModel;
import trabalho.bosing.medicos.clientes.service.EnderecoService;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.IEnderecoInterface")
public class EnderecoWebService implements IEnderecoInterface{
    
    EnderecoService es = new EnderecoService();

    @Override
    public EnderecoModel insertEndereco(EnderecoModel em) throws SQLException, ValidacaoException {

        return es.insert(em);

    }

    @Override
    public ArrayList<EnderecoModel> selectAllEndereco() throws SQLException, ValidacaoException {

        return es.selectAll();
        
    }

    @Override
    public EnderecoModel selectByIdEndereco(int id) throws SQLException, ValidacaoException {

        return es.selectById(id);
        
    }

    @Override
    public EnderecoModel updateEndereco(EnderecoModel em) throws SQLException, ValidacaoException {

        return es.update(em);

    }

    @Override
    public EnderecoModel desativatedEndereco(EnderecoModel em) throws SQLException, ValidacaoException {

        return es.desativated(em);

    }
    
}
