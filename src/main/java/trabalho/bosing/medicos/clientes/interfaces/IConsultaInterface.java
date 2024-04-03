package trabalho.bosing.medicos.clientes.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.ConsultaModel;

@WebService
public interface IConsultaInterface {

    @WebMethod
    ConsultaModel insertConsulta (ConsultaModel conm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ArrayList<ConsultaModel> selectAllConsulta() throws SQLException, ValidacaoException;
    
    @WebMethod
    ConsultaModel selectByIdConsulta(int id) throws SQLException, ValidacaoException;
    
    @WebMethod
    ConsultaModel updateConsulta (ConsultaModel conm) throws SQLException, ValidacaoException;
    
    @WebMethod
    ConsultaModel desativatedConsulta (ConsultaModel conm, String motivoCancelamento) throws SQLException, ValidacaoException;
    
}
