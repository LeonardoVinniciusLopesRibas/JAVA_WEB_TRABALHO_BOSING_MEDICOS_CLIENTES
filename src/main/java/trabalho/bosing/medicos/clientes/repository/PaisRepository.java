package trabalho.bosing.medicos.clientes.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.infrastructure.ConnectionFactory;
import trabalho.bosing.medicos.clientes.model.PaisModel;

public class PaisRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public PaisModel insert(PaisModel paism) throws SQLException, ValidacaoException {

        query = "INSERT INTO pais (nome, ativo) VALUES (?,?)";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, paism.getNome());
            pstmt.setBoolean(2, true);
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
        return paism;

    }

    public ArrayList<PaisModel> selectAll() throws SQLException, ValidacaoException {

        ArrayList<PaisModel> pais = new ArrayList<>();

        query = "SELECT id, nome, ativo FROM pais WHERE ativo = true";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                PaisModel pm = new PaisModel();
                pm.setId(rs.getInt("id"));
                pm.setNome(rs.getString("nome"));
                pm.setAtivo(rs.getBoolean("ativo"));

                pais.add(pm);
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
        return pais;

    }

    public PaisModel selectById(int id) throws SQLException, ValidacaoException {

        PaisModel paisModel = null;
        query = "SELECT id, nome, ativo FROM pais WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                paisModel.setId(rs.getInt("id"));
                paisModel.setNome(rs.getString("nome"));
                paisModel.setAtivo(rs.getBoolean("ativo"));
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
        return paisModel;

    }

    public void update(PaisModel paism) throws SQLException, ValidacaoException {

        query = "UPDATE pais SET nome = ? WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, paism.getNome());
            pstmt.setInt(2, paism.getId());

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

    public void desativated(PaisModel paism) throws SQLException, ValidacaoException {

        query = "UPDATE pais SET ativo = ? WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, paism.getId());
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
