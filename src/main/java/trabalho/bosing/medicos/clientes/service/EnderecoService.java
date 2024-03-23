package trabalho.bosing.medicos.clientes.service;

import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.EnderecoModel;
import trabalho.bosing.medicos.clientes.repository.EnderecoRepository;

public class EnderecoService {

    String erroInterno = "ERRO INTERNO NO SERVIDOR - CONTATE O SUPORTE";
    EnderecoRepository er = new EnderecoRepository();

    public EnderecoModel insert(EnderecoModel em) throws ValidacaoException {

        if (em.getLogradouro().length() <= 3) {
            throw new ValidacaoException("Logradouro não foi preenchido");
        }
        if (em.getLogradouro().length() >= 30) {
            throw new ValidacaoException("Logradouro tem limite de 30 caracteres");
        }
        if (em.getBairro().length() >= 20) {
            throw new ValidacaoException("Bairro tem limite de 30 caracteres");
        }
        if (em.getComplemento().length() >= 50) {
            throw new ValidacaoException("Complemento tem limite de 50 caracteres");
        }
        if (em.getNumero().length() > 10) {
            throw new ValidacaoException("Número tem limite de 10 caracteres");
        }
        if (em.getCep().length() <= 3) {
            throw new ValidacaoException("Cep não foi preenchido");
        }
        if (em.getCep().length() >= 9) {
            throw new ValidacaoException("Cep tem limite de 8 caracteres");
        }
        if (em.getBairro().length() <= 3) {
            throw new ValidacaoException("Bairro não foi preenchido");
        }

        if (em.getCidade_id() == null) {
            throw new ValidacaoException("Cidade não foi preenchida");
        }

        try {
            return er.insert(em);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }
    }

    public ArrayList<EnderecoModel> selectAll() throws ValidacaoException {

        try {
            return er.selectAll();
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public EnderecoModel selectById(int id) throws ValidacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Id não foi preenchido");
        }

        try {
            return er.selectById(id);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public EnderecoModel update(EnderecoModel em) throws ValidacaoException {

        if (em.getLogradouro().length() <= 3) {
            throw new ValidacaoException("Logradouro não foi preenchido");
        }
        if (em.getBairro().length() >= 20) {
            throw new ValidacaoException("Bairro tem limite de 30 caracteres");
        }
        if (em.getComplemento().length() >= 50) {
            throw new ValidacaoException("Complemento tem limite de 50 caracteres");
        }
        if (em.getNumero().length() > 10) {
            throw new ValidacaoException("Número tem limite de 10 caracteres");
        }
        if (em.getCep().length() <= 3) {
            throw new ValidacaoException("Cep não foi preenchido");
        }
        if (em.getCep().length() >= 9) {
            throw new ValidacaoException("Cep tem limite de 8 caracteres");
        }
        if (em.getBairro().length() <= 3) {
            throw new ValidacaoException("Bairro não foi preenchido");
        }
        if (em.getCidade_id() == null) {
            throw new ValidacaoException("Cidade não foi preenchida");
        }

        try {
            er.update(em);
            return em;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public EnderecoModel desativated(EnderecoModel em) throws ValidacaoException {

        if (em.getLogradouro().length() <= 3) {
            throw new ValidacaoException("Logradouro não foi preenchido");
        }
        if (em.getBairro().length() >= 20) {
            throw new ValidacaoException("Bairro tem limite de 30 caracteres");
        }
        if (em.getComplemento().length() >= 50) {
            throw new ValidacaoException("Complemento tem limite de 50 caracteres");
        }
        if (em.getNumero().length() > 10) {
            throw new ValidacaoException("Número tem limite de 10 caracteres");
        }
        if (em.getCep().length() <= 3) {
            throw new ValidacaoException("Cep não foi preenchido");
        }
        if (em.getCep().length() >= 9) {
            throw new ValidacaoException("Cep tem limite de 8 caracteres");
        }
        if (em.getBairro().length() <= 3) {
            throw new ValidacaoException("Bairro não foi preenchido");
        }
        if (em.getCidade_id() == null) {
            throw new ValidacaoException("Cidade não foi preenchida");
        }

        try {
            er.desativated(em);
            return em;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

}
