package com.airline.airline.dto;

import com.airline.airline.entities.Aerolinea;
import com.airline.airline.entities.Aeropuerto;
import com.airline.airline.entities.Reserva;

import java.time.LocalDate;
import java.time.LocalTime;

public record VueloDTO(Long id,
                       String origen,
                       String destino,
                       LocalDate fechaDeSalida,
                       LocalTime horaDeSalida,
                       Integer capacidad,
                       Double precio,
                       String img,
                       Long aerolinea,
                       Long aeropuerto,
                       LocalTime duracion) {
}
