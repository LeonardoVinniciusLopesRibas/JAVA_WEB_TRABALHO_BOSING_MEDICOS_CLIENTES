package trabalho.bosing.medicos.clientes.model;

import trabalho.bosing.medicos.clientes.abstracts.IdAtivoAbstract;

public  class PaisModel extends IdAtivoAbstract{   
    
    private String nome;

    public PaisModel() {
    }

    public PaisModel(String nome, int id, boolean ativo) {
        super(id, ativo);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
}
