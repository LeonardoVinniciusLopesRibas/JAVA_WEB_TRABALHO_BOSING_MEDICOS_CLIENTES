package trabalho.bosing.medicos.clientes.model;

import trabalho.bosing.medicos.clientes.abastract.IdAtivoAbstract;

public class EnderecoModel extends IdAtivoAbstract{
    
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeModel cidade_id;

    public EnderecoModel() {
    }

    public EnderecoModel(String cep, String logradouro, String numero, String complemento, String bairro, CidadeModel cidade_id, int id, boolean ativo) {
        super(id, ativo);
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade_id = cidade_id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public CidadeModel getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(CidadeModel cidade_id) {
        this.cidade_id = cidade_id;
    }

    
    
    
    
}
