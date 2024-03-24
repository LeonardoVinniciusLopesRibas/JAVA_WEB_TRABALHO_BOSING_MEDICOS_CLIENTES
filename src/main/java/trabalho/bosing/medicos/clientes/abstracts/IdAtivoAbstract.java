package trabalho.bosing.medicos.clientes.abstracts;

public abstract class IdAtivoAbstract {
    
    private int id;
    private boolean ativo;

    public IdAtivoAbstract() {
    }

    public IdAtivoAbstract(int id, boolean ativo) {
        this.id = id;
        this.ativo = ativo;
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
}
