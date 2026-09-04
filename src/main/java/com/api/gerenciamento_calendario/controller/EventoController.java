package com.api.gerenciamento_calendario.controller;

import com.api.gerenciamento_calendario.infrastructure.entity.EventoEntity;
import com.api.gerenciamento_calendario.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor

public class EventoController {
    public final EventoService eventoService;

    @PostMapping
    public ResponseEntity<EventoEntity> salvarEvento (@RequestBody EventoEntity evento){
        return ResponseEntity.accepted().body(eventoService.salvarEvento(evento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarEvento(@RequestParam LocalDateTime data,
                                              @RequestParam String ministerio) {
        eventoService.deletarEvento(data, ministerio);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EventoEntity>> buscarEvento(@RequestBody LocalDate data) {
        return ResponseEntity.ok().body(eventoService.buscarEvento(data));
    }

    @PutMapping
    public ResponseEntity<EventoEntity> alterarEvento(@RequestBody EventoEntity evento,
                                                      @RequestParam LocalDateTime data,
                                                      @RequestParam String ministerio) {
        return ResponseEntity.accepted().body(eventoService.alterarEvento(evento, ministerio, data));
    }
}
