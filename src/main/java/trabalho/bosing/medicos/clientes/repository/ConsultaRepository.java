package trabalho.bosing.medicos.clientes.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.infrastructure.ConnectionFactory;
import trabalho.bosing.medicos.clientes.model.ConsultaModel;
import trabalho.bosing.medicos.clientes.model.MedicoModel;
import trabalho.bosing.medicos.clientes.model.PacienteModel;

public class ConsultaRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public ConsultaModel insert(ConsultaModel conm) throws SQLException, ValidacaoException {

        query = "INSERT INTO consulta (data_hora_consulta, paciente_id, medico_id, data_hora_fim_consulta, ativo) VALUES (?,?,?,?,?)";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);

            Date dataHoraInicio = conm.getDataHoraConsulta();
            pstmt.setTimestamp(1, new java.sql.Timestamp(dataHoraInicio.getTime()));
            pstmt.setInt(2, conm.getPaciente().getId());
            pstmt.setInt(3, conm.getMedico().getId());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataHoraInicio);
            calendar.add(Calendar.HOUR, 1);
            Date dataHoraFim = calendar.getTime();
            pstmt.setTimestamp(4, new java.sql.Timestamp(dataHoraFim.getTime()));

            pstmt.setBoolean(5, true);

            pstmt.executeUpdate();

            return conm;

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public ArrayList<ConsultaModel> selectAll() throws SQLException, ValidacaoException {

        ArrayList<ConsultaModel> consulta = new ArrayList<>();
        query = "SELECT id, data_hora_consulta, paciente_id, medico_id, data_hora_fim_consulta FROM consulta WHERE ativo = true";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ConsultaModel conm = new ConsultaModel();
                conm.setId(rs.getInt("id"));
                conm.setDataHoraConsulta(rs.getTimestamp("data_hora_consulta"));
                conm.setPaciente(new PacienteRepository().selectById(rs.getInt("paciente_id")));
                conm.setMedico(new MedicoRepository().selectById(rs.getInt("medico_id")));
                conm.setDataHoraFimConsulta(rs.getTimestamp("data_hora_fim_consulta"));

                consulta.add(conm);
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
        return consulta;

    }

    public ConsultaModel selectById(int id) throws SQLException, ValidacaoException {

        ConsultaModel consultaModel = null;

        query = "SELECT id, data_hora_consulta, paciente_id, medico_id, data_hora_fim_consulta, ativo FROM consulta WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                consultaModel = new ConsultaModel();
                consultaModel.setId(rs.getInt("id"));
                consultaModel.setDataHoraConsulta(rs.getTimestamp("data_hora_consulta"));
                consultaModel.setPaciente(new PacienteRepository().selectById(rs.getInt("paciente_id")));
                consultaModel.setMedico(new MedicoRepository().selectById(rs.getInt("medico_id")));
                consultaModel.setDataHoraFimConsulta(rs.getTimestamp("data_hora_fim_consulta"));
                consultaModel.setAtivo(rs.getBoolean("ativo"));
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
        return consultaModel;
    }

    public void update(ConsultaModel conm) throws SQLException, ValidacaoException {

        query = "UPDATE consulta SET data_hora_consulta = ?, paciente_id = ?, medico_id = ?, data_hora_fim_consulta = ? WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);

            Date dataHoraInicio = conm.getDataHoraConsulta();
            pstmt.setTimestamp(1, new java.sql.Timestamp(dataHoraInicio.getTime()));
            pstmt.setInt(2, conm.getPaciente().getId());
            pstmt.setInt(3, conm.getMedico().getId());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataHoraInicio);
            calendar.add(Calendar.HOUR, 1);
            Date dataHoraFim = calendar.getTime();
            pstmt.setTimestamp(4, new java.sql.Timestamp(dataHoraFim.getTime()));
            pstmt.setInt(5, conm.getId());
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

    public void desativated(ConsultaModel conm, String motivoCancelamento) throws SQLException, ValidacaoException {

        query = "UPDATE consulta SET ativo = ? WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, conm.getId());
            pstmt.executeUpdate();
            CancelamentoConsultaRepository ccr = new CancelamentoConsultaRepository();
            ccr.insertDiferenciado(conm, motivoCancelamento);
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    void activatedDiferenciado(ConsultaModel conm, int id) throws SQLException, ValidacaoException {
        query = "UPDATE consulta SET ativo = ? WHERE id = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, id);
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

    public ArrayList<ConsultaModel> selectByPacienteAndDate(PacienteModel paciente, Date data) throws SQLException, ValidacaoException {
        ArrayList<ConsultaModel> consultas = new ArrayList<>();
        query = "SELECT id, data_hora_consulta, paciente_id, medico_id, data_hora_fim_consulta FROM consulta WHERE paciente_id = ? AND DATE(data_hora_consulta) = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, paciente.getId());
            pstmt.setDate(2, new java.sql.Date(data.getTime()));
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ConsultaModel conm = new ConsultaModel();
                conm.setId(rs.getInt("id"));
                conm.setDataHoraConsulta(rs.getTimestamp("data_hora_consulta"));
                conm.setPaciente(paciente);
                conm.setMedico(new MedicoRepository().selectById(rs.getInt("medico_id")));
                conm.setDataHoraFimConsulta(rs.getTimestamp("data_hora_fim_consulta"));

                consultas.add(conm);
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
        return consultas;
    }

    public ArrayList<ConsultaModel> selectByMedicoAndDate(MedicoModel medico, Date dataHoraConsulta) throws SQLException, ValidacaoException {
        ArrayList<ConsultaModel> consultas = new ArrayList<>();
        query = "SELECT id, data_hora_consulta, paciente_id, medico_id, data_hora_fim_consulta FROM consulta WHERE medico_id = ? AND data_hora_consulta = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, medico.getId());
            pstmt.setTimestamp(2, new java.sql.Timestamp(dataHoraConsulta.getTime()));
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ConsultaModel conm = new ConsultaModel();
                conm.setId(rs.getInt("id"));
                conm.setDataHoraConsulta(rs.getTimestamp("data_hora_consulta"));
                conm.setPaciente(new PacienteRepository().selectById(rs.getInt("paciente_id")));
                conm.setMedico(medico);
                conm.setDataHoraFimConsulta(rs.getTimestamp("data_hora_fim_consulta"));

                consultas.add(conm);
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
        return consultas;
    }

}
