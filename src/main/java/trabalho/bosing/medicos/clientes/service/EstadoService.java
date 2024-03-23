package trabalho.bosing.medicos.clientes.service;

import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.EstadoModel;
import trabalho.bosing.medicos.clientes.repository.EstadoRepository;

public class EstadoService {

    String erroInterno = "ERRO INTERNO NO SERVIDOR - CONTATE O SUPORTE";
    EstadoRepository estr = new EstadoRepository();

    public EstadoModel insert(EstadoModel estm) throws ValidacaoException {

        if (estm.getNome().length() <= 3) {
            throw new ValidacaoException("Nome não foi preenchido");
        }
        if (estm.getNome().length() >= 25) {
            throw new ValidacaoException("Nome tem limite de 25 caracteres");
        }
        if (estm.getUf().length() <= 1) {
            throw new ValidacaoException("Uf não foi preenchido");
        }
        if (estm.getUf().length() >= 5) {
            throw new ValidacaoException("Uf tem limite de 5 caracteres");
        }
        if (estm.getPais_id() == null) {
            throw new ValidacaoException("Pais não foi preenchido");
        }

        try {
            return estr.insert(estm);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public ArrayList<EstadoModel> selectAll() throws ValidacaoException {

        try {
            return estr.selectAll();
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public EstadoModel selectById(int id) throws ValidacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Id não foi preenchido");
        }
        try {
            return estr.selectById(id);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }
    }

    public EstadoModel update(EstadoModel estm) throws ValidacaoException {

        if (estm.getNome().length() <= 3) {
            throw new ValidacaoException("Nome não foi preenchido");
        }
        if (estm.getNome().length() >= 25) {
            throw new ValidacaoException("Nome tem limite de 25 caracteres");
        }
        if (estm.getUf().length() <= 1) {
            throw new ValidacaoException("Uf não foi preenchido");
        }
        if (estm.getUf().length() >= 5) {
            throw new ValidacaoException("Uf tem limite de 5 caracteres");
        }
        if (estm.getPais_id() == null) {
            throw new ValidacaoException("Pais não foi preenchido");
        }

        try {
            estr.update(estm);
            return estm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public EstadoModel desativated(EstadoModel estm) throws ValidacaoException {

        if (estm.getNome().length() <= 3) {
            throw new ValidacaoException("Nome não foi preenchido");
        }
        if (estm.getNome().length() >= 25) {
            throw new ValidacaoException("Nome tem limite de 25 caracteres");
        }
        if (estm.getUf().length() <= 1) {
            throw new ValidacaoException("Uf não foi preenchido");
        }
        if (estm.getUf().length() >= 5) {
            throw new ValidacaoException("Uf tem limite de 5 caracteres");
        }
        if (estm.getPais_id() == null) {
            throw new ValidacaoException("Pais não foi preenchido");
        }

        try {
            estr.desativated(estm);
            return estm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

}
