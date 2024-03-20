package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.IEnderecoInterface;
import trabalho.bosing.medicos.clientes.model.EnderecoModel;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.web.service.IEnderecoInterface")
public class EnderecoWebService implements IEnderecoInterface{

    @Override
    public EnderecoModel insert(EnderecoModel em) throws SQLException, ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<EnderecoModel> selectAll() throws SQLException, ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EnderecoModel selectById(int id) throws SQLException, ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EnderecoModel update(EnderecoModel em) throws SQLException, ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EnderecoModel desativated(EnderecoModel em) throws SQLException, ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
