package com.api.gerenciamento_calendario.infrastructure.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="evento")

public class EventoEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String evento;

    @NotBlank
    private String ministerio;

    //Dia que será agendado
    @NotNull
    private LocalDateTime data;

    private LocalDateTime dataInsercao = LocalDateTime.now();

    //@NotNull
    //private LocalTime horaInicio;
}
