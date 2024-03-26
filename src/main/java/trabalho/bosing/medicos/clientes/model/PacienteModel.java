package trabalho.bosing.medicos.clientes.model;

import trabalho.bosing.medicos.clientes.abstracts.IdAtivoAbstract;


public class PacienteModel extends IdAtivoAbstract{
    

    private PessoaModel pessoaModel;

    public PacienteModel() {
    }


    public PacienteModel(PessoaModel pessoaModel, int id, boolean ativo) {
        super(id, ativo);
        this.pessoaModel = pessoaModel;
    }

    public PessoaModel getPessoaModel() {
        return pessoaModel;
    }

    public void setPessoaModel(PessoaModel pessoaModel) {
        this.pessoaModel = pessoaModel;
    }

    
    
}
