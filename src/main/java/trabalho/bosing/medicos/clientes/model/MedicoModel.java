package trabalho.bosing.medicos.clientes.model;


public class MedicoModel{
    
    private int id;
    private boolean ativo;
    private PessoaModel pessoaModel;    
    private String crm;
    private EspecialidadeModel especialidade_id;
    

    public MedicoModel() {
    }

    public MedicoModel(int id, boolean ativo, PessoaModel pessoaModel, String crm, EspecialidadeModel especialidade_id) {
        this.id = id;
        this.ativo = ativo;
        this.pessoaModel = pessoaModel;
        this.crm = crm;
        this.especialidade_id = especialidade_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
