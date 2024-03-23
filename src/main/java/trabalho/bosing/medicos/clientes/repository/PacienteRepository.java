package trabalho.bosing.medicos.clientes.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.infrastructure.ConnectionFactory;
import trabalho.bosing.medicos.clientes.model.PacienteModel;
import trabalho.bosing.medicos.clientes.model.PessoaModel;

public class PacienteRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public PacienteModel insert(PacienteModel pm) throws SQLException, ValidacaoException {

        query = "INSERT INTO paciente (ativo, pessoa_id) VALUES (?, ?)";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, pm.getPessoaModel().getId());
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
        return pm;
    }

    public ArrayList<PacienteModel> selectAll() throws SQLException, ValidacaoException {

        ArrayList<PacienteModel> paciente = new ArrayList<>();
        query = "SELECT id, ativo, pessoa_id FROM paciente WHERE ativo = true";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                PacienteModel pm = new PacienteModel();
                pm.setId(rs.getInt("id"));
                pm.setAtivo(rs.getBoolean("ativo"));
                pm.setPessoaModel(new PessoaRepository().selectById(rs.getInt("pessoa_id")));

                paciente.add(pm);
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
        return paciente;

    }

    public PacienteModel selectById(int id) throws SQLException, ValidacaoException {

        PacienteModel pacienteModel = null;
        query = "SELECT id, ativo, pessoa_id FROM paciente WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                pacienteModel.setId(rs.getInt("id"));
                pacienteModel.setAtivo(rs.getBoolean("ativo"));
                pacienteModel.setPessoaModel(new PessoaRepository().selectById(rs.getInt("pessoa_id")));
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
        return pacienteModel;
    }

    public void update(PacienteModel pm) throws SQLException, ValidacaoException {

        query = "UPDATE paciente SET pessoa_id = ? WHERE id = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, pm.getPessoaModel().getId());
            pstmt.setInt(2, pm.getId());

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

    public void desativated(PacienteModel pm) throws SQLException, ValidacaoException {

        query = "UPDATE paciente SET ativo = ? WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, pm.getId());
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
