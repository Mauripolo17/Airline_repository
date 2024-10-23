package com.airline.airline.dto;

import com.airline.airline.entities.Aerolinea;
import com.airline.airline.entities.Aeropuerto;
import com.airline.airline.entities.Reserva;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

public record VueloDTO(Long id, String origen, String destino, Date fechaDeSalida, LocalTime horaDeSalida, Integer capacidad, Aerolinea aerolinea, Aeropuerto aeropuerto, LocalTime duracion, Long aerolineaId, Long aeropuertoId, Set<Reserva> reservas) {
}
