package com.api.gerenciamento_calendario.service;


import com.api.gerenciamento_calendario.infrastructure.entity.EventoEntity;
import com.api.gerenciamento_calendario.infrastructure.repository.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoEntity salvarEvento (EventoEntity evento) {
        //Data a qual desejo agendar
        LocalDateTime dataAgendada = evento.getData();
        LocalDateTime horaFim = evento.getData().plusHours(2);


        EventoEntity eventoEntity = eventoRepository.findByEventoAndDataBetween(evento.getEvento()
                ,dataAgendada, horaFim);
        if (Objects.nonNull(eventoEntity)) {
            throw new RuntimeException("\n\nData já selecionada\n\n");
        }
        return eventoRepository.save(evento);
    }

    public void deletarEvento(LocalDateTime data, String ministerio) {
        eventoRepository.deleteByDataAndMinisterio(data, ministerio);
    }

    public List<EventoEntity> listarEventos(LocalDate data) {
        LocalDateTime primeiraHoraMes = data.withDayOfMonth(1).atStartOfDay();
        LocalDateTime ultimaHoraMes = data.withDayOfMonth(data.lengthOfMonth()).atTime(23, 59, 59);

        return eventoRepository.findByDataBetween(primeiraHoraMes, ultimaHoraMes);
    }
}
