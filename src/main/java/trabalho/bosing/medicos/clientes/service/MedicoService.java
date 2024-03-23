package trabalho.bosing.medicos.clientes.service;

import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.MedicoModel;
import trabalho.bosing.medicos.clientes.repository.MedicoRepository;

public class MedicoService {

    String erroInterno = "ERRO INTERNO NO SERVIDOR - CONTATE O SUPORTE";
    MedicoRepository mr = new MedicoRepository();

    public MedicoModel insert(MedicoModel mm) throws ValidacaoException {

        if (mm.getCrm().length() <= 3) {
            throw new ValidacaoException("Crm não foi preenchido");
        }
        if (mm.getCrm().length() > 6) {
            throw new ValidacaoException("Crm tem limite de 6 caracteres");
        }
        if (mm.getPessoaModel() == null) {
            throw new ValidacaoException("Pessoa não foi preenchida");
        }
        if (mm.getEspecialidade_id() == null) {
            throw new ValidacaoException("Especialidade não foi preenchida");
        }
        try {
            return mr.insert(mm);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }
    }

    public ArrayList<MedicoModel> selectAll() throws ValidacaoException {

        try {
            return mr.selectAll();
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public MedicoModel selectById(int id) throws ValidacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Id não foi preenchido");
        }
        try {
            return mr.selectById(id);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public MedicoModel update(MedicoModel mm) throws ValidacaoException {

        if (mm.getCrm().length() <= 3) {
            throw new ValidacaoException("Crm não foi preenchido");
        }
        if (mm.getCrm().length() > 6) {
            throw new ValidacaoException("Crm tem limite de 6 caracteres");
        }
        if (mm.getPessoaModel() == null) {
            throw new ValidacaoException("Pessoa não foi preenchida");
        }
        if (mm.getEspecialidade_id() == null) {
            throw new ValidacaoException("Especialidade não foi preenchida");
        }
        try {
            mr.update(mm);
            return mm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public MedicoModel desativated(MedicoModel mm) throws ValidacaoException {

        if (mm.getCrm().length() <= 3) {
            throw new ValidacaoException("Crm não foi preenchido");
        }
        if (mm.getCrm().length() > 6) {
            throw new ValidacaoException("Crm tem limite de 6 caracteres");
        }
        if (mm.getPessoaModel() == null) {
            throw new ValidacaoException("Pessoa não foi preenchida");
        }
        if (mm.getEspecialidade_id() == null) {
            throw new ValidacaoException("Especialidade não foi preenchida");
        }
        try {
            mr.desativated(mm);
            return mm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

}
