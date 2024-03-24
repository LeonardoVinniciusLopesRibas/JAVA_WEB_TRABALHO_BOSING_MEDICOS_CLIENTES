package trabalho.bosing.medicos.clientes.model;

import trabalho.bosing.medicos.clientes.abstracts.IdAtivoAbstract;

public class EstadoModel extends IdAtivoAbstract{
    
    private String nome;
    private String uf;
    private PaisModel pais_id;

    public EstadoModel() {
    }

    public EstadoModel(String nome, String uf, PaisModel pais_id, int id, boolean ativo) {
        super(id, ativo);
        this.nome = nome;
        this.uf = uf;
        this.pais_id = pais_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public PaisModel getPais_id() {
        return pais_id;
    }

    public void setPais_id(PaisModel pais_id) {
        this.pais_id = pais_id;
    }

    
    
    
}
