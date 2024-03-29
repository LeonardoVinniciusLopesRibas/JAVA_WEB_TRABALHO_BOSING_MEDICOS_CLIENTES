package trabalho.bosing.medicos.clientes.service;

import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.PacienteModel;
import trabalho.bosing.medicos.clientes.repository.PacienteRepository;

public class PacienteService {

    String erroInterno = "ERRO INTERNO NO SERVIDOR - CONTATE O SUPORTE";
    PacienteRepository pr = new PacienteRepository();

    public PacienteModel insert(PacienteModel pm) throws ValidacaoException {

        if (pm.getPessoaModel() == null) {
            throw new ValidacaoException("Pessoa não foi preenchida");
        }

        try {
            return pr.insert(pm);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public ArrayList<PacienteModel> selectAll() throws ValidacaoException {

        try {
            return pr.selectAll();
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public PacienteModel selectById(int id) throws ValidacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Id não foi preenchido");
        }
        try {
            return pr.selectById(id);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public PacienteModel update(PacienteModel pm) throws ValidacaoException {

        if (pm.getId() <1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }

        try {
            pr.update(pm);
            return pm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public PacienteModel desativated(PacienteModel pm) throws ValidacaoException {

        if (pm.getId() <1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }

        try {
            pr.desativated(pm);
            return pm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

}
