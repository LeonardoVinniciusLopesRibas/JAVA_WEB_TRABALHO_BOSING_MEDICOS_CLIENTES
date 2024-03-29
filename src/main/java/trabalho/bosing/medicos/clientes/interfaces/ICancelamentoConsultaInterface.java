package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.CancelamentoConsultaModel;

@WebService
public interface ICancelamentoConsultaInterface {
    
    @WebMethod
    CancelamentoConsultaModel insertCancelamentoConsulta (CancelamentoConsultaModel ccm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<CancelamentoConsultaModel> selectAllCancelamentoConsulta() throws SQLException, ValidacaoException;
    
    @WebMethod
    CancelamentoConsultaModel selectByIdCancelamentoConsulta(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    CancelamentoConsultaModel updateCancelamentoConsulta (CancelamentoConsultaModel ccm) throws SQLException, ValidacaoException;
    
    @WebMethod
    CancelamentoConsultaModel desativatedCancelamentoConsulta (CancelamentoConsultaModel ccm) throws SQLException, ValidacaoException;
    
    
}
