package com.airline.airline.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vuelos")
@Entity
public class Vuelo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP) @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaDeSalida;

    @Column(nullable = false)  @Temporal(TemporalType.TIME)  @DateTimeFormat(iso = ISO.TIME)
    private LocalTime horaDeSalida;

    @Column(nullable = false) @DateTimeFormat(pattern = "HH:mm")
    private LocalTime duracion;

    @Column(nullable = false)
    private int capacidad;

    @Column(nullable = true)
    private double precio;

    @Column
    private String img;


    @ManyToOne(targetEntity = Aerolinea.class, fetch = FetchType.EAGER)
    private Aerolinea aerolinea;

    @ManyToOne(targetEntity = Aeropuerto.class, fetch = FetchType.EAGER)
    private Aeropuerto aeropuerto;

    @JsonIgnore
    @ManyToMany(mappedBy = "vuelos")
    private Set<Reserva> reservas;
}
