package trabalho.bosing.medicos.clientes.model;

import trabalho.bosing.medicos.clientes.abastract.IdAtivoAbstract;

public class MedicoModel extends IdAtivoAbstract{
    
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private EspecialidadeModel especialidade_id;
    private EnderecoModel endereco_id;

    public MedicoModel() {
    }

    public MedicoModel(String nome, String email, String telefone, String crm, EspecialidadeModel especialidade_id, EnderecoModel endereco_id, int id, boolean ativo) {
        super(id, ativo);
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.crm = crm;
        this.especialidade_id = especialidade_id;
        this.endereco_id = endereco_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public EnderecoModel getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(EnderecoModel endereco_id) {
        this.endereco_id = endereco_id;
    }
    
    
    
    
}
