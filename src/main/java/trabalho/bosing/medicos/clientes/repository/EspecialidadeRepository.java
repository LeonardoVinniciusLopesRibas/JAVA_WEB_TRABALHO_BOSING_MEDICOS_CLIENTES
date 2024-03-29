package trabalho.bosing.medicos.clientes.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.infrastructure.ConnectionFactory;
import trabalho.bosing.medicos.clientes.model.EspecialidadeModel;

public class EspecialidadeRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    public EspecialidadeModel insert(EspecialidadeModel epm) throws SQLException, ValidacaoException{

        query = "INSERT INTO especialidade (descricao, ativo) VALUES (?, ?)";
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, epm.getDescricao());
            pstmt.setBoolean(2, true);
            
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
        return epm;
    }

    public ArrayList<EspecialidadeModel> selectAll() throws SQLException, ValidacaoException{

        ArrayList<EspecialidadeModel> especialidadeModel = new ArrayList<>();
        query = "SELECT id, descricao, ativo FROM especialidade WHERE ativo = true";
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                EspecialidadeModel em = new EspecialidadeModel();
                em.setId(rs.getInt("id"));
                em.setDescricao(rs.getString("descricao"));
                em.setAtivo(rs.getBoolean("ativo"));
                especialidadeModel.add(em);
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
        return especialidadeModel;

    }

    public EspecialidadeModel selectById(int id) throws SQLException, ValidacaoException{

        EspecialidadeModel especialidadeModel = null;
        query = "SELECT id, descricao, ativo FROM especialidade WHERE id = ?";
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                especialidadeModel = new EspecialidadeModel();
                especialidadeModel.setId(rs.getInt("id"));
                especialidadeModel.setDescricao(rs.getString("descricao"));
                especialidadeModel.setAtivo(rs.getBoolean("ativo"));
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
        return especialidadeModel;

    }

    public void update(EspecialidadeModel epm) throws SQLException, ValidacaoException{

        query = "UPDATE especialidade SET descricao = ? WHERE id = ?";
        
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, epm.getDescricao());
            pstmt.setInt(2, epm.getId());
            
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

    public void desativated(EspecialidadeModel epm) throws SQLException, ValidacaoException{

        query = "UPDATE especialidade SET ativo = ? WHERE id = ?";
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, epm.getId());
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