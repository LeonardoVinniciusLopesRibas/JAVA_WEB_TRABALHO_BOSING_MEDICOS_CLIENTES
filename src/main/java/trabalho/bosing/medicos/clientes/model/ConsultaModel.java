package trabalho.bosing.medicos.clientes.model;

import java.util.Date;
import trabalho.bosing.medicos.clientes.abstracts.IdAtivoAbstract;

public class ConsultaModel extends IdAtivoAbstract{
    private PacienteModel paciente;
    private MedicoModel medico;
    private Date dataHoraConsulta;
    private Date dataHoraFimConsulta;

    public ConsultaModel() {
    }

    public ConsultaModel(PacienteModel paciente, MedicoModel medico, Date dataHoraConsulta, Date dataHoraFimConsulta, int id, boolean ativo) {
        super(id, ativo);
        this.paciente = paciente;
        this.medico = medico;
        this.dataHoraConsulta = dataHoraConsulta;
        this.dataHoraFimConsulta = dataHoraFimConsulta;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medico) {
        this.medico = medico;
    }

    public Date getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(Date dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public Date getDataHoraFimConsulta() {
        return dataHoraFimConsulta;
    }

    public void setDataHoraFimConsulta(Date dataHoraFimConsulta) {
        this.dataHoraFimConsulta = dataHoraFimConsulta;
    }

    
    
    
    
    
}
