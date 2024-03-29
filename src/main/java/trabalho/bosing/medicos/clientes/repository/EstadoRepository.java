package trabalho.bosing.medicos.clientes.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.infrastructure.ConnectionFactory;
import trabalho.bosing.medicos.clientes.model.EstadoModel;

public class EstadoRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    public EstadoModel insert(EstadoModel estm) throws SQLException, ValidacaoException{

        query = "INSERT INTO estado (nome, uf, ativo, pais_id) VALUES (?, ?, ?, ?)";
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, estm.getNome());
            pstmt.setString(2, estm.getUf());
            pstmt.setBoolean(3, true);
            pstmt.setInt(4, estm.getPais_id().getId());
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
        return estm;

    }

    public ArrayList<EstadoModel> selectAll() throws SQLException, ValidacaoException{

        ArrayList<EstadoModel> estadoModel = new ArrayList<>();
        query = "SELECT id, nome, uf, ativo, pais_id FROM estado WHERE ativo = true";
        
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            while (rs.next()){
                EstadoModel estm = new EstadoModel();
                estm.setId(rs.getInt("id"));
                estm.setNome(rs.getString("nome"));
                estm.setUf(rs.getString("uf"));
                estm.setAtivo(rs.getBoolean("ativo"));
                estm.setPais_id(new PaisRepository().selectById(rs.getInt("pais_id")));
                
                estadoModel.add(estm);
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
        return estadoModel;
        
        
    }

    public EstadoModel selectById(int id) throws SQLException, ValidacaoException{

        EstadoModel estadoModel = null;
        query = "SELECT id, nome, uf, ativo, pais_id FROM estado WHERE id = ?";
        
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                estadoModel = new EstadoModel();
                estadoModel.setId(rs.getInt("id"));
                estadoModel.setNome(rs.getString("nome"));
                estadoModel.setUf(rs.getString("uf"));
                estadoModel.setAtivo(rs.getBoolean("ativo"));
                estadoModel.setPais_id(new PaisRepository().selectById(rs.getInt("pais_id")));
            }
        } finally {
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
        return estadoModel;
    }

    public void update(EstadoModel estm) throws SQLException, ValidacaoException{

        query = "UPDATE estado SET nome = ?, uf = ?, pais_id = ? WHERE id = ?";
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, estm.getNome());
            pstmt.setString(2, estm.getUf());
            pstmt.setInt(3, estm.getPais_id().getId());
            pstmt.setInt(4, estm.getId());
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

    public void desativated(EstadoModel estm) throws SQLException, ValidacaoException{

        query = "UPDATE estado SET ativo = ? WHERE id = ?";
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, estm.getId());
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