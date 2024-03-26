package trabalho.bosing.medicos.clientes.model;

import trabalho.bosing.medicos.clientes.abstracts.IdAtivoAbstract;

public class MedicoModel extends IdAtivoAbstract{
    
    private PessoaModel pessoaModel;    
    private String crm;
    private EspecialidadeModel especialidade_id;
    

    public MedicoModel() {
    }

    public MedicoModel(PessoaModel pessoaModel, String crm, EspecialidadeModel especialidade_id, int id, boolean ativo) {
        super(id, ativo);
        this.pessoaModel = pessoaModel;
        this.crm = crm;
        this.especialidade_id = especialidade_id;
    }

    public PessoaModel getPessoaModel() {
        return pessoaModel;
    }

    public void setPessoaModel(PessoaModel pessoaModel) {
        this.pessoaModel = pessoaModel;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public EspecialidadeModel getEspecialidade_id() {
        return especialidade_id;
    }

    public void setEspecialidade_id(EspecialidadeModel especialidade_id) {
        this.especialidade_id = especialidade_id;
    }

    
    

    

    
    
    
    
    
}
