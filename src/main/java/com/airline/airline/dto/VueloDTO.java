package com.airline.airline.dto;

import com.airline.airline.entities.Aerolinea;
import com.airline.airline.entities.Aeropuerto;

import java.time.LocalTime;
import java.util.Date;

public record VueloDTO(Long id, String origen, String destino, Date fechaDeSalida, LocalTime horaDeSalida, Integer capacidad, Aerolinea aerolinea, Aeropuerto aeropuerto) {
}
