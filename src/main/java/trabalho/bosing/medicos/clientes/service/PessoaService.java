package trabalho.bosing.medicos.clientes.service;

import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.PaisModel;
import trabalho.bosing.medicos.clientes.model.PessoaModel;
import trabalho.bosing.medicos.clientes.repository.PessoaRepository;

public class PessoaService {

    String erroInterno = "ERRO INTERNO NO SERVIDOR - CONTATE O SUPORTE";
    PessoaRepository pessr = new PessoaRepository();

    public PessoaModel insert(PessoaModel pessm) throws ValidacaoException {

        if (pessm.getNome().length() <= 3) {
            throw new ValidacaoException("Nome não foi preenchido");
        }
        if (pessm.getNome().length() > 150) {
            throw new ValidacaoException("Nome tem um limite de 30 caracteres");
        }
        if (pessm.getCpf().length() > 11) {
            throw new ValidacaoException("Cpf tem limite de 11 caracteres");
        }
        if (pessm.getEmail().length() > 100) {
            throw new ValidacaoException("Email tem limite de 50 caracteres");
        }
        if (pessm.getTelefone().length() > 15) {
            throw new ValidacaoException("Telefone tem limite de 15 caracteres");
        }
        if (pessm.getTelefone().length() <= 3) {
            throw new ValidacaoException("Telefone não foi preenchido");
        }
        if (pessm.getEmail().length() <= 3) {
            throw new ValidacaoException("Email não foi preenchido");
        }
        if (pessm.getCpf().length() <= 3) {
            throw new ValidacaoException("Cpf não foi preenchido");
        }
        if (pessm.getEndereco_id() == null) {
            throw new ValidacaoException("Endereco não foi preenchido");
        }

        try {
            return pessr.insert(pessm);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public ArrayList<PessoaModel> selectAll() throws ValidacaoException {

        try {
            return pessr.selectAll();
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public PessoaModel selectById(int id) throws ValidacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Id não foi preenchido");
        }
        try {
            return pessr.selectById(id);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public PessoaModel update(PessoaModel pessm) throws ValidacaoException {

        if (pessm.getId() <1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }

        try {
            pessr.update(pessm);
            return pessm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public PessoaModel desativated(PessoaModel pessm) throws ValidacaoException {

        if (pessm.getId() <1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }

        try {
            pessr.desativated(pessm);
            return pessm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

}
