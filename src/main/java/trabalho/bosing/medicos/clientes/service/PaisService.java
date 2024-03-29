package trabalho.bosing.medicos.clientes.service;

import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.PaisModel;
import trabalho.bosing.medicos.clientes.repository.PaisRepository;

public class PaisService {

    String erroInterno = "ERRO INTERNO NO SERVIDOR - CONTATE O SUPORTE";
    PaisRepository paisr = new PaisRepository();

    public PaisModel insert(PaisModel paism) throws ValidacaoException {

        if (paism.getNome().length() <= 3) {
            throw new ValidacaoException("Nome não foi preenchido");
        }
        if (paism.getNome().length() > 100) {
            throw new ValidacaoException("Nome tem limite de 30 caracteres");
        }
        try {
            return paisr.insert(paism);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public ArrayList<PaisModel> selectAll() throws ValidacaoException {

        try {
            return paisr.selectAll();
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public PaisModel selectById(int id) throws ValidacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Id não foi preenchido");
        }
        try {
            return paisr.selectById(id);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public PaisModel update(PaisModel paism) throws ValidacaoException {

        if (paism.getId() <1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }

        try {
            paisr.update(paism);
            return paism;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public PaisModel desativated(PaisModel paism) throws ValidacaoException {

        if (paism.getId() <1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }
        try {
            paisr.desativated(paism);
            return paism;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

}
