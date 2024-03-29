package trabalho.bosing.medicos.clientes.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.infrastructure.ConnectionFactory;
import trabalho.bosing.medicos.clientes.model.EnderecoModel;

public class EnderecoRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public EnderecoModel insert(EnderecoModel em) throws SQLException, ValidacaoException {

        query = "INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, ativo, cidade_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, em.getCep());
            pstmt.setString(2, em.getLogradouro());
            pstmt.setString(3, em.getNumero());
            pstmt.setString(4, em.getComplemento());
            pstmt.setString(5, em.getBairro());
            pstmt.setBoolean(6, true);
            pstmt.setInt(7, em.getCidade_id().getId());
            pstmt.executeUpdate();
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
        return em;
    }

    public ArrayList<EnderecoModel> selectAll() throws SQLException, ValidacaoException {

        ArrayList<EnderecoModel> endereco = new ArrayList<>();
        query = "SELECT id, cep, logradouro, numero, complemento, bairro, ativo, cidade_id FROM endereco WHERE ativo = true";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                EnderecoModel em = new EnderecoModel();
                em.setId(rs.getInt("id"));
                em.setCep(rs.getString("cep"));
                em.setLogradouro(rs.getString("logradouro"));
                em.setNumero(rs.getString("numero"));
                em.setComplemento(rs.getString("complemento"));
                em.setBairro(rs.getString("bairro"));
                em.setAtivo(rs.getBoolean("ativo"));
                em.setCidade_id(new CidadeRepository().selectById(rs.getInt("cidade_id")));

                endereco.add(em);
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
        return endereco;
    }

    public EnderecoModel selectById(int id) throws SQLException, ValidacaoException {

        EnderecoModel enderecoModel = null;
        query = "SELECT id, cep, logradouro, numero, complemento, bairro, ativo, cidade_id FROM endereco WHERE id = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                enderecoModel = new EnderecoModel();
                enderecoModel.setId(rs.getInt("id"));
                enderecoModel.setCep(rs.getString("cep"));
                enderecoModel.setLogradouro(rs.getString("logradouro"));
                enderecoModel.setNumero(rs.getString("numero"));
                enderecoModel.setComplemento(rs.getString("complemento"));
                enderecoModel.setBairro(rs.getString("bairro"));
                enderecoModel.setAtivo(rs.getBoolean("ativo"));
                enderecoModel.setCidade_id(new CidadeRepository().selectById(rs.getInt("cidade_id")));

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
        return enderecoModel;

    }

    public void update(EnderecoModel em) throws SQLException, ValidacaoException {

        query = "UPDATE endereco SET cep = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade_id = ? WHERE id = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, em.getCep());
            pstmt.setString(2, em.getLogradouro());
            pstmt.setString(3, em.getNumero());
            pstmt.setString(4, em.getComplemento());
            pstmt.setString(5, em.getBairro());
            pstmt.setInt(6, em.getCidade_id().getId());
            pstmt.setInt(7, em.getId());

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

    public void desativated(EnderecoModel em) throws SQLException, ValidacaoException {

        query = "UPDATE endereco SET ativo = ? WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, em.getId());
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

}
