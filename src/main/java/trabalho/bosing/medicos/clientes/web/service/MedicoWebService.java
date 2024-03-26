package trabalho.bosing.medicos.clientes.web.service;

import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.interfaces.IMedicoInterface;
import trabalho.bosing.medicos.clientes.model.MedicoModel;
import trabalho.bosing.medicos.clientes.service.MedicoService;

@WebService(endpointInterface = "trabalho.bosing.medicos.clientes.interfaces.IMedicoInterface")
public class MedicoWebService implements IMedicoInterface{

    MedicoService ms = new MedicoService();
    
    @Override
    public MedicoModel insertMedico(MedicoModel mm) throws SQLException, ValidacaoException {

        return ms.insert(mm);
        
    }

    @Override
    public ArrayList<MedicoModel> selectAllMedico() throws SQLException, ValidacaoException {

        return ms.selectAll();

    }

    @Override
    public MedicoModel selectByIdMedico(int id) throws SQLException, ValidacaoException {

        return ms.selectById(id);

    }

    @Override
    public MedicoModel updateMedico(MedicoModel mm) throws SQLException, ValidacaoException {

        return ms.update(mm);

    }

    @Override
    public MedicoModel desativatedMedico(MedicoModel mm) throws SQLException, ValidacaoException {

        return ms.desativated(mm);

    }
    
}
