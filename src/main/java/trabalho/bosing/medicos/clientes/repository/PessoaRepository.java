package trabalho.bosing.medicos.clientes.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.infrastructure.ConnectionFactory;
import trabalho.bosing.medicos.clientes.model.PessoaModel;

public class PessoaRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public PessoaModel insert(PessoaModel pessm) throws SQLException, ValidacaoException {

        query = "INSERT INTO pessoa (nome, cpf, email, endereco_id, telefone, ativo) VALUES (?, ?, ?, ?, ? ,?)";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, pessm.getNome());
            pstmt.setString(2, pessm.getCpf());
            pstmt.setString(3, pessm.getEmail());
            pstmt.setInt(4, pessm.getEndereco_id().getId());
            pstmt.setString(5, pessm.getTelefone());
            pstmt.setBoolean(6, true);
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
        return pessm;

    }

    public ArrayList<PessoaModel> selectAll() throws SQLException, ValidacaoException {

        ArrayList<PessoaModel> pessoa = new ArrayList<>();
        query = "SELECT id, nome, cpf, email, endereco_id, telefone, ativo FROM pessoa WHERE ativo = true";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                PessoaModel pm = new PessoaModel();
                pm.setId(rs.getInt("id"));
                pm.setNome(rs.getString("nome"));
                pm.setCpf(rs.getString("cpf"));
                pm.setEmail(rs.getString("email"));
                pm.setEndereco_id(new EnderecoRepository().selectById(rs.getInt("endereco_id")));
                pm.setTelefone(rs.getString("telefone"));
                pm.setAtivo(rs.getBoolean("ativo"));

                pessoa.add(pm);
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
        return pessoa;
    }

    public PessoaModel selectById(int id) throws SQLException, ValidacaoException {

        PessoaModel pessoaModel = null;
        query = "SELECT id, nome, cpf, email, endereco_id, telefone, ativo FROM pessoa WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                pessoaModel = new PessoaModel();
                pessoaModel.setId(rs.getInt("id"));
                pessoaModel.setNome(rs.getString("nome"));
                pessoaModel.setCpf(rs.getString("cpf"));
                pessoaModel.setEmail(rs.getString("email"));
                pessoaModel.setEndereco_id(new EnderecoRepository().selectById(rs.getInt("endereco_id")));
                pessoaModel.setTelefone(rs.getString("telefone"));
                pessoaModel.setAtivo(rs.getBoolean("ativo"));
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
        return pessoaModel;

    }

    public void update(PessoaModel pessm) throws SQLException, ValidacaoException {

        query = "UPDATE pessoa SET nome = ?, cpf = ?, email = ?, endereco_id = ?, telefone = ? WHERE id = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, pessm.getNome());
            pstmt.setString(2, pessm.getCpf());
            pstmt.setString(3, pessm.getEmail());
            pstmt.setInt(4, pessm.getEndereco_id().getId());
            pstmt.setString(5, pessm.getTelefone());
            pstmt.setInt(6, pessm.getId());

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

    public void desativated(PessoaModel pessm) throws SQLException, ValidacaoException {

        query = "UPDATE pessoa SET ativo = ? WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, pessm.getId());
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
