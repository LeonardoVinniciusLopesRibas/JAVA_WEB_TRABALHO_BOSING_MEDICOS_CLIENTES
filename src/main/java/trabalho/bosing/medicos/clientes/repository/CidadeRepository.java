package trabalho.bosing.medicos.clientes.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.infrastructure.ConnectionFactory;
import trabalho.bosing.medicos.clientes.model.CidadeModel;

public class CidadeRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public CidadeModel insert(CidadeModel cm) throws SQLException, ValidacaoException {
        query = "INSERT INTO cidade (nome, ativo, estado_id) VALUES (?, ?, ?)";

        try {
            conn = new ConnectionFactory().getConnection();

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, cm.getNome());
            pstmt.setBoolean(2, true);
            pstmt.setInt(3, cm.getEstado_id().getId());
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
        return cm;

    }

    public ArrayList<CidadeModel> selectAll() throws SQLException, ValidacaoException {

        ArrayList<CidadeModel> cidade = new ArrayList<>();
        query = "SELECT id, nome, ativo, estado_id FROM cidade WHERE ativo = true";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CidadeModel cm = new CidadeModel();
                cm.setId(rs.getInt("id"));
                cm.setNome(rs.getString("nome"));
                cm.setAtivo(rs.getBoolean("ativo"));
                cm.setEstado_id(new EstadoRepository().selectById(rs.getInt("estado_id")));

                cidade.add(cm);
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
        return cidade;

    }

    public CidadeModel selectById(int id) throws SQLException, ValidacaoException {

        CidadeModel cidadeModel = null;
        query = "SELECT id, nome, ativo, estado_id FROM cidade WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                cidadeModel.setId(rs.getInt("id"));
                cidadeModel.setNome(rs.getString("nome"));
                cidadeModel.setAtivo(rs.getBoolean("ativo"));
                cidadeModel.setEstado_id(new EstadoRepository().selectById(rs.getInt("estado_id")));
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
        return cidadeModel;

    }

    public void update(CidadeModel cm) throws SQLException, ValidacaoException {

        query = "UPDATE cidade SET nome = ?, estado_id = ? WHERE id = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, cm.getNome());
            pstmt.setInt(2, cm.getEstado_id().getId());
            pstmt.setInt(3, cm.getId());

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

    public void desativated(CidadeModel cm) throws SQLException, ValidacaoException {

        query = "UPDATE cidade SET ativo = ? WHERE id = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, cm.getId());
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