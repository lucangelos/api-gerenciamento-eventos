package com.api.gerenciamento_calendario.infrastructure.repository;

import com.api.gerenciamento_calendario.infrastructure.entity.EventoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
    EventoEntity findByEventoAndDataBetween(String evento, LocalDateTime dataAgendada, LocalDateTime horaFim);

    @Transactional
    void deleteByDataAndMinisterio(LocalDateTime data,
                                   String ministerio);

    List<EventoEntity> findByDataBetween(LocalDateTime primeiraHoraMes,
                                         LocalDateTime ultimaHoraMes);

    EventoEntity findByDataAndMinisterio(LocalDateTime data,
                                         String ministerio);
}
