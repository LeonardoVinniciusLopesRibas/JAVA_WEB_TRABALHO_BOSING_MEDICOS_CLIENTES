package trabalho.bosing.medicos.clientes.service;

import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.CidadeModel;
import trabalho.bosing.medicos.clientes.repository.CidadeRepository;

public class CidadeService {

    String erroInterno = "ERRO INTERNO NO SERVIDOR - CONTATE O SUPORTE";
    CidadeRepository cr = new CidadeRepository();

    public CidadeModel insert(CidadeModel cm) throws ValidacaoException {

        if (cm.getNome().length() <= 3) {
            throw new ValidacaoException("Cidade não foi preenchido");
        }
        if (cm.getNome().length() >= 30) {
            throw new ValidacaoException("Cidade tem limite de 30 caracteres");
        }
        if (cm.getEstado_id() == null) {
            throw new ValidacaoException("Estado não foi preenchido");
        }

        try {
            return cr.insert(cm);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }
    }

    public ArrayList<CidadeModel> selectAll() throws ValidacaoException {

        try {
            return cr.selectAll();
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public CidadeModel selectById(int id) throws ValidacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Id não foi preenchido");
        }

        try {
            return cr.selectById(id);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }
    }

    public CidadeModel update(CidadeModel cm) throws ValidacaoException {

        if (cm.getId() <1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }
        try {
            cr.update(cm);
            return cm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }
    }

    public CidadeModel desativated(CidadeModel cm) throws ValidacaoException {

        if (cm.getId() <1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }

        try {
            cr.desativated(cm);
            return cm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }
    }

}
