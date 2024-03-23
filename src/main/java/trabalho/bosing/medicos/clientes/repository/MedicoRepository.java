package trabalho.bosing.medicos.clientes.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.infrastructure.ConnectionFactory;
import trabalho.bosing.medicos.clientes.model.MedicoModel;

public class MedicoRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    public MedicoModel insert(MedicoModel mm) throws SQLException, ValidacaoException{

        query = "INSERT INTO medico (crm, ativo, especialidade_id, pessoa_id) VALUES (?, ?, ?, ?)";
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, mm.getCrm());
            pstmt.setBoolean(2, true);
            pstmt.setInt(3, mm.getEspecialidade_id().getId());
            pstmt.setInt(4, mm.getPessoaModel().getId());
            
            pstmt.executeUpdate();
        }finally {

            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return mm;

    }

    public ArrayList<MedicoModel> selectAll() throws SQLException, ValidacaoException{

        ArrayList<MedicoModel> medico = new ArrayList<>();
        query = "SELECT id, crm, ativo, especialidade_id, pessoa_id FROM medico WHERE ativo = true";
        
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            while (rs.next()){
                MedicoModel mm = new MedicoModel();
                mm.setId(rs.getInt("id"));
                mm.setCrm(rs.getString("crm"));
                mm.setAtivo(rs.getBoolean("ativo"));
                mm.setEspecialidade_id(new EspecialidadeRepository().selectById(rs.getInt("especialidade_id")));
                mm.setPessoaModel(new PessoaRepository().selectById(rs.getInt("pessoa_id")));
                
                medico.add(mm);
            }
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return medico;

    }

    public MedicoModel selectById(int id) throws SQLException, ValidacaoException{

        MedicoModel medicoModel = null;
        query = "SELECT id, crm, ativo, especialidade_id, pessoa_id WHERE id = ?";
        
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                medicoModel.setId(rs.getInt("id"));
                medicoModel.setCrm(rs.getString("crm"));
                medicoModel.setAtivo(rs.getBoolean("ativo"));
                medicoModel.setEspecialidade_id(new EspecialidadeRepository().selectById(rs.getInt("especialidade_id")));
                medicoModel.setPessoaModel(new PessoaRepository().selectById(rs.getInt("pessoa_id")));
                
            }
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return medicoModel;
    }

    public void update(MedicoModel mm) throws SQLException, ValidacaoException{

        query = "UPDATE medico SET crm = ?, especialidade_id = ?, pessoa_id = ? WHERE id = ?";
        
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, mm.getCrm());
            pstmt.setInt(2, mm.getEspecialidade_id().getId());
            pstmt.setInt(3, mm.getPessoaModel().getId());
            
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        

    }

    public void desativated(MedicoModel mm) throws SQLException, ValidacaoException{

        query = "UPDATE medico SET ativo = ? WHERE id = ?";
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, mm.getId());
            pstmt.executeUpdate();
        }finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
    
}
