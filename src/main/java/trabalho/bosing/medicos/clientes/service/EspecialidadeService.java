package trabalho.bosing.medicos.clientes.service;

import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.EspecialidadeModel;
import trabalho.bosing.medicos.clientes.repository.EspecialidadeRepository;

public class EspecialidadeService {

    String erroInterno = "ERRO INTERNO NO SERVIDOR - CONTATE O SUPORTE";
    EspecialidadeRepository epr = new EspecialidadeRepository();

    public EspecialidadeModel insert(EspecialidadeModel epm) throws ValidacaoException {

        if (epm.getDescricao().length() <= 3) {
            throw new ValidacaoException("Descricao não foi preenchido");
        }
        if (epm.getDescricao().length() >= 30) {
            throw new ValidacaoException("Descricao tem limite de 30 caracteres");
        }
        try {
            return epr.insert(epm);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public ArrayList<EspecialidadeModel> selectAll() throws ValidacaoException {

        try {
            return epr.selectAll();
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public EspecialidadeModel selectById(int id) throws ValidacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Id não foi preenchido");
        }

        try {
            return epr.selectById(id);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public EspecialidadeModel update(EspecialidadeModel epm) throws ValidacaoException {

        if (epm.getDescricao().length() <= 3) {
            throw new ValidacaoException("Descricao não foi preenchido");
        }
        if (epm.getDescricao().length() >= 30) {
            throw new ValidacaoException("Descricao tem limite de 30 caracteres");
        }

        try {
            epr.update(epm);
            return epm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public EspecialidadeModel desativated(EspecialidadeModel epm) throws ValidacaoException {

        if (epm.getDescricao().length() <= 3) {
            throw new ValidacaoException("Descricao não foi preenchido");
        }
        if (epm.getDescricao().length() >= 30) {
            throw new ValidacaoException("Descricao tem limite de 30 caracteres");
        }

        try {
            epr.desativated(epm);
            return epm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

}
