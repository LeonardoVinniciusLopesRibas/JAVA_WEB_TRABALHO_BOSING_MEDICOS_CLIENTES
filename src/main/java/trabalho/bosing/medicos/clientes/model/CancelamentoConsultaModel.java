package trabalho.bosing.medicos.clientes.model;

import java.util.Date;
import trabalho.bosing.medicos.clientes.abstracts.IdAtivoAbstract;

public class CancelamentoConsultaModel extends IdAtivoAbstract{
    
    private String motivoCancelamento;
    private Date dataHoraCancelamentoConsulta;
    private ConsultaModel consulta;

    public CancelamentoConsultaModel() {
    }

    public CancelamentoConsultaModel(String motivoCancelamento, Date dataHoraCancelamentoConsulta, ConsultaModel consulta, int id, boolean ativo) {
        super(id, ativo);
        this.motivoCancelamento = motivoCancelamento;
        this.dataHoraCancelamentoConsulta = dataHoraCancelamentoConsulta;
        this.consulta = consulta;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public Date getDataHoraCancelamentoConsulta() {
        return dataHoraCancelamentoConsulta;
    }

    public void setDataHoraCancelamentoConsulta(Date dataHoraCancelamentoConsulta) {
        this.dataHoraCancelamentoConsulta = dataHoraCancelamentoConsulta;
    }

    public ConsultaModel getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaModel consulta) {
        this.consulta = consulta;
    }
    
    


    
}
