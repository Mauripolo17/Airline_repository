package com.airline.airline.dto;

import com.airline.airline.entities.Reserva;

import java.util.Date;

public record PasajeroDTO(Long id, String nombre, String apellido, String tipoDocumento, Integer numeroDocumento,
                          Date fechaNacimiento, Long reserva) {
}
