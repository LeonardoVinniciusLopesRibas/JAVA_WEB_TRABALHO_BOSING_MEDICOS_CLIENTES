package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.IConsultaInterface;
import trabalho.bosing.medicos.clientes.model.ConsultaModel;
import trabalho.bosing.medicos.clientes.service.ConsultaService;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.IConsultaInterface")
public class ConsultaWebService implements IConsultaInterface{
    
    ConsultaService cons = new ConsultaService();

    @Override
    public ConsultaModel insertConsulta(ConsultaModel conm) throws SQLException, ValidacaoException {

        return cons.insert(conm);

    }

    @Override
    public ArrayList<ConsultaModel> selectAllConsulta() throws SQLException, ValidacaoException {

        return cons.selectAll();

    }

    @Override
    public ConsultaModel selectByIdConsulta(int id) throws SQLException, ValidacaoException {

        return cons.selectById(id);
        
    }

    @Override
    public ConsultaModel updateConsulta(ConsultaModel conm) throws SQLException, ValidacaoException {

        return cons.update(conm);

    }

    @Override
    public ConsultaModel desativatedConsulta(ConsultaModel conm) throws SQLException, ValidacaoException {
        
        return cons.desativated(conm);
        
    }
    
}
