package trabalho.bosing.medicos.clientes.model;

import trabalho.bosing.medicos.clientes.abastract.IdAtivoAbstract;

public class PacienteModel extends IdAtivoAbstract{
    
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private EnderecoModel endereco_id;

    public PacienteModel() {
    }

    public PacienteModel(String nome, String email, String telefone, String cpf, EnderecoModel endereco_id, int id, boolean ativo) {
        super(id, ativo);
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EnderecoModel getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(EnderecoModel endereco_id) {
        this.endereco_id = endereco_id;
    }
    
    
    
    
}
