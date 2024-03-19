package trabalho.bosing.medicos.clientes.model;

import trabalho.bosing.medicos.clientes.abastract.IdAtivoAbstract;

public class CidadeModel extends IdAtivoAbstract{
    
    private String nome;
    private EstadoModel estado_id;

    public CidadeModel() {
    }

    public CidadeModel(String nome, EstadoModel estado_id, int id, boolean ativo) {
        super(id, ativo);
        this.nome = nome;
        this.estado_id = estado_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoModel getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(EstadoModel estado_id) {
        this.estado_id = estado_id;
    }

    
    
}
