package trabalho.bosing.medicos.clientes.model;

import trabalho.bosing.medicos.clientes.abstracts.IdAtivoAbstract;

public class EspecialidadeModel extends IdAtivoAbstract{
    
    private String descricao;

    public EspecialidadeModel() {
    }

    public EspecialidadeModel(String descricao, int id, boolean ativo) {
        super(id, ativo);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
