package trabalho.bosing.medicos.clientes.service;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import trabalho.bosing.medicos.clientes.exception.ValidacaoException;
import trabalho.bosing.medicos.clientes.model.ConsultaModel;
import trabalho.bosing.medicos.clientes.repository.ConsultaRepository;

public class ConsultaService {

    String erroInterno = "ERRO INTERNO NO SERVIDOR - CONTATE O SUPORTE";
    ConsultaRepository conr = new ConsultaRepository();
    private static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
    private static final LocalTime HORARIO_ABERTURA = LocalTime.of(7, 0);
    private static final LocalTime HORARIO_FECHAMENTO = LocalTime.of(19, 0);

    public ConsultaModel insert(ConsultaModel conm) throws ValidacaoException {

        if (conm.getMedico() == null) {
            throw new ValidacaoException("Médico é obrigatório");
        }
        if (conm.getPaciente() == null) {
            throw new ValidacaoException("Paciente é obrigatório");
        }

        if (!conm.getMedico().isAtivo()) {
            throw new ValidacaoException("Esse médico está inativo");
        }

        if (!conm.getPaciente().isAtivo()) {
            throw new ValidacaoException("Esse paciente está inativo");
        }

        if (!isHorarioAtendimento(conm.getDataHoraConsulta())) {
            throw new ValidacaoException("Fora do horário de atendimento!");
        }

        if (!antecedenciaMinima(conm.getDataHoraConsulta())) {
            throw new ValidacaoException("É necessário agendar a consulta com 30 minutos de antecedência");
        }

        try {
            return conr.insert(conm);
        } catch (Exception e) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public ArrayList<ConsultaModel> selectAll() throws ValidacaoException {

        try {
            return conr.selectAll();
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public ConsultaModel selectById(int id) throws ValidacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Id não foi preenchido");
        }

        try {
            return conr.selectById(id);
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public ConsultaModel update(ConsultaModel conm) throws ValidacaoException {

        if (conm.getId() < 1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }
        try {
            conr.update(conm);
            return conm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    public ConsultaModel desativated(ConsultaModel conm, String motivoCancelamento) throws ValidacaoException {

        if (conm.getId() < 1) {
            throw new ValidacaoException("Id preenchido de maneira incorreta");
        }
        if(motivoCancelamento.length() <1){
            throw new ValidacaoException("Informe um motivo de cancelamento, dentre DESISTENCIA, CANCELAMENTO e OUTROS!");
        }

        
        if(!motivoCancelamento.equals("DESISTENCIA") && !motivoCancelamento.equals("CANCELAMENTO") && !motivoCancelamento.equals("OUTROS")){
            throw new ValidacaoException("PREENCHER APENAS DESISTENCIA, CANCELAMENTO OU OUTROS");
        }
        
        try {
            conr.desativated(conm, motivoCancelamento);
            return conm;
        } catch (Exception ex) {
            throw new ValidacaoException(erroInterno);
        }

    }

    private boolean isHorarioAtendimento(Date dataHoraConsulta) {
        ZonedDateTime consulta = ZonedDateTime.ofInstant(dataHoraConsulta.toInstant(), ZONE_ID);
        DayOfWeek diaSemana = consulta.getDayOfWeek();

        if (diaSemana == DayOfWeek.SUNDAY) {
            return false;
        }

        LocalTime horaAgora = consulta.toLocalTime();
        return horaAgora.isAfter(HORARIO_ABERTURA) && horaAgora.isBefore(HORARIO_FECHAMENTO);

    }

    private boolean antecedenciaMinima(Date dataHoraConsulta) {
        ZonedDateTime agora = ZonedDateTime.now(ZONE_ID);
        ZonedDateTime consulta = ZonedDateTime.ofInstant(dataHoraConsulta.toInstant(), ZONE_ID);

        long minutos = Duration.between(agora, consulta).toMinutes();

        return minutos >= 30;
    }

}
