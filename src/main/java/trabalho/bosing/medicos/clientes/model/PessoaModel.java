package trabalho.bosing.medicos.clientes.model;

import trabalho.bosing.medicos.clientes.abstracts.IdAtivoAbstract;

public class PessoaModel extends IdAtivoAbstract{
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private EnderecoModel endereco_id;

    public PessoaModel() {
    }

    public PessoaModel(String nome, String cpf, String email, String telefone, EnderecoModel endereco_id, int id, boolean ativo) {
        super(id, ativo);
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco_id = endereco_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public EnderecoModel getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(EnderecoModel endereco_id) {
        this.endereco_id = endereco_id;
    }

    
    
    
    
}
