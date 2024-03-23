package trabalho.bosing.medicos.clientes.model;


public class PacienteModel{
    
    private int id;
    private boolean ativo;
    private PessoaModel pessoaModel;

    public PacienteModel() {
    }

    public PacienteModel(int id, boolean ativo, PessoaModel pessoaModel) {
        this.id = id;
        this.ativo = ativo;
        this.pessoaModel = pessoaModel;
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

    
    
    
    
    
    
}
