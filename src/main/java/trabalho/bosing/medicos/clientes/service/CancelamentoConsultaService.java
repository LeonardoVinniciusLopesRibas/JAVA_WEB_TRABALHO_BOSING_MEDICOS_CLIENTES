package trabalho.bosing.medicos.clientes.service;

import java.time.Instant;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.CancelamentoConsultaModel;
import trabalho.bosing.medicos.clientes.repository.CancelamentoConsultaRepository;

public class CancelamentoConsultaService {

    String erroInterno = "ERRO INTERNO NO SERVIDRO - CONTATE O SUPORTE";
    CancelamentoConsultaRepository ccr = new CancelamentoConsultaRepository();
    public CancelamentoConsultaModel insert(CancelamentoConsultaModel ccm) throws ValidacaoException{

        if(ccm.getConsulta() == null){
            throw new ValidacaoException("Consulta que vai ser desativada é obrigatório");
        }
        
        if(ccm.getMotivoCancelamento().length()<1){
            throw new ValidacaoException("Cancelamento deve ser preenchido");
        }
        
        if(ccm.getMotivoCancelamento() != "DESISTENCIA" || ccm.getMotivoCancelamento() != "CANCELAMENTO" || ccm.getMotivoCancelamento()!= "OUTROS"){
            throw new ValidacaoException("PREENCHER APENAS DESISTENCIA, CANCELAMENTO OU OUTROS");
        }
        
        if(ccm.getDataHoraCancelamentoConsulta() == null){
            throw new ValidacaoException("Data de cancelamento não foi preenchida");
        }
        
        Instant agora = Instant.now();
        Instant dataHoraCancelamentoInformada = ccm.getDataHoraCancelamentoConsulta().toInstant();
        if(dataHoraCancelamentoInformada.isAfter(agora)){
            throw new ValidacaoException("Data não pode ser maior que a atual");
        }
        
        try{
            return ccr.insert(ccm);
        }catch(Exception e){
            throw new ValidacaoException(erroInterno);
        }

    }

    public ArrayList<CancelamentoConsultaModel> selectAll() throws ValidacaoException{

        try{
            return ccr.selectAll();
        }catch(Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public CancelamentoConsultaModel selectById(int id)throws ValidacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Id não foi preenchido");
        }

        try {
            return ccr.selectById(id);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }
        
    }

    public CancelamentoConsultaModel update(CancelamentoConsultaModel ccm) throws ValidacaoException{

        if (ccm.getId() <1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }
        try {
            ccr.update(ccm);
            return ccm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public CancelamentoConsultaModel desativated(CancelamentoConsultaModel ccm) throws ValidacaoException{

        if (ccm.getId() <1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }

        try {
            ccr.desativated(ccm);
            return ccm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }
    
}
