package trabalho.bosing.medicos.clientes.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.infrastructure.ConnectionFactory;
import trabalho.bosing.medicos.clientes.model.CancelamentoConsultaModel;
import trabalho.bosing.medicos.clientes.model.ConsultaModel;

public class CancelamentoConsultaRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public CancelamentoConsultaModel insert(CancelamentoConsultaModel ccm) throws SQLException, ValidacaoException {

        query = "INSERT INTO cancelamento_consulta (motivo_cancelamento, "
                + "data_hora_cancelamento_consulta,"
                + " consulta_id, ativo) VALUES(?, ?, ?, ?)";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);

            /*
            
            Instant agora = Instant.now();
        Instant dataHoraCancelamentoInformada = agora;
        if(dataHoraCancelamentoInformada.isAfter(agora)){
            
             */
            pstmt.setString(1, ccm.getMotivoCancelamento());
            LocalDateTime agora = LocalDateTime.now();
            pstmt.setTimestamp(2, Timestamp.valueOf(agora));
            pstmt.setInt(3, ccm.getConsulta().getId());
            pstmt.setBoolean(4, true);

            pstmt.executeUpdate();

            return ccm;
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public ArrayList<CancelamentoConsultaModel> selectAll() throws SQLException, ValidacaoException {

        ArrayList<CancelamentoConsultaModel> cancelamentoConsulta = new ArrayList<>();
        query = "SELECT id, motivo_cancelamento, "
                + "data_hora_cancelamento_consulta, "
                + "consulta_id FROM cancelamento_consulta WHERE ativo = true";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CancelamentoConsultaModel ccm = new CancelamentoConsultaModel();
                ccm.setId(rs.getInt("id"));
                ccm.setMotivoCancelamento(rs.getString("motivo_cancelamento"));
                ccm.setDataHoraCancelamentoConsulta(rs.getTimestamp("data_hora_cancelamento_consulta"));
                ccm.setConsulta(new ConsultaRepository().selectById(rs.getInt("consulta_id")));
                cancelamentoConsulta.add(ccm);
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
        return cancelamentoConsulta;

    }

    public CancelamentoConsultaModel selectById(int id) throws SQLException, ValidacaoException {

        CancelamentoConsultaModel cancelamentoConsulta = null;
        query = "SELECT id, motivo_cancelamento,"
                + " data_hora_cancelamento_consulta,"
                + " consulta_id, ativo"
                + " FROM cancelamento_consulta WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                cancelamentoConsulta = new CancelamentoConsultaModel();
                cancelamentoConsulta.setId(rs.getInt("id"));
                cancelamentoConsulta.setMotivoCancelamento(rs.getString("motivo_cancelamento"));
                cancelamentoConsulta.setDataHoraCancelamentoConsulta(rs.getTimestamp("data_hora_cancelamento_consulta"));
                cancelamentoConsulta.setConsulta(new ConsultaRepository().selectById(rs.getInt("consulta_id")));
                cancelamentoConsulta.setAtivo(rs.getBoolean("ativo"));
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
        return cancelamentoConsulta;

    }

    public void update(CancelamentoConsultaModel ccm) throws SQLException, ValidacaoException {

        query = "UPDATE cancelamento_consulta "
                + "SET motivo_cancelamento = ?, "
                + "consulta_id = ? WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, ccm.getMotivoCancelamento());
            //Date dataHoraCancelamento = ccm.getDataHoraCancelamentoConsulta();
            //pstmt.setTimestamp(2, new java.sql.Timestamp(dataHoraCancelamento.getTime()));
            pstmt.setInt(2, ccm.getConsulta().getId());
            pstmt.setInt(3, ccm.getId());
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

    public void desativated(CancelamentoConsultaModel ccm) throws SQLException, ValidacaoException {

        query = "UPDATE cancelamento_consulta SET ativo = ? WHERE id = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, ccm.getId());
            pstmt.executeUpdate();
            ConsultaRepository conr = new ConsultaRepository();
            ConsultaModel conm = new ConsultaModel();
            int id = ccm.getId();
            conr.activatedDiferenciado(conm, id);
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    void insertDiferenciado(ConsultaModel conm, String motivoCancelamento)throws SQLException, ValidacaoException {

        query = "INSERT INTO cancelamento_consulta (motivo_cancelamento, data_hora_cancelamento_consulta, consulta_id, ativo) VALUES(?, ?, ?, ?)";

        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, motivoCancelamento);
            LocalDateTime agora = LocalDateTime.now();
            pstmt.setTimestamp(2, Timestamp.valueOf(agora));
            pstmt.setInt(3, conm.getId());
            pstmt.setBoolean(4, true);
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

