package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.IEspecialidadeInterface;
import trabalho.bosing.medicos.clientes.model.EspecialidadeModel;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.IEspecialidadeInterface")
public class EspecialidadeWebService implements IEspecialidadeInterface{

    @Override
    public EspecialidadeModel insert(EspecialidadeModel epm) throws SQLException, ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<EspecialidadeModel> selectAll() throws SQLException, ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EspecialidadeModel selectById(int id) throws SQLException, ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EspecialidadeModel update(EspecialidadeModel epm) throws SQLException, ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EspecialidadeModel desativated(EspecialidadeModel epm) throws SQLException, ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
