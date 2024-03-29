package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.ICancelamentoConsultaInterface;
import trabalho.bosing.medicos.clientes.model.CancelamentoConsultaModel;
import trabalho.bosing.medicos.clientes.service.CancelamentoConsultaService;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.ICancelamentoConsultaInterface")
public class CancelamentoConsultaWebService implements ICancelamentoConsultaInterface{

    CancelamentoConsultaService ccs = new CancelamentoConsultaService();
    
    @Override
    public CancelamentoConsultaModel insertCancelamentoConsulta(CancelamentoConsultaModel ccm) throws SQLException, ValidacaoException {

        return ccs.insert(ccm);

    }

    @Override
    public ArrayList<CancelamentoConsultaModel> selectAllCancelamentoConsulta() throws SQLException, ValidacaoException {

        return ccs.selectAll();

    }

    @Override
    public CancelamentoConsultaModel selectByIdCancelamentoConsulta(int id) throws SQLException, ValidacaoException {

        return ccs.selectById(id);
        
    }

    @Override
    public CancelamentoConsultaModel updateCancelamentoConsulta(CancelamentoConsultaModel ccm) throws SQLException, ValidacaoException {

        return ccs.update(ccm);

    }

    @Override
    public CancelamentoConsultaModel desativatedCancelamentoConsulta(CancelamentoConsultaModel ccm) throws SQLException, ValidacaoException {
        
        return ccs.desativated(ccm);
        
    }
    
}
