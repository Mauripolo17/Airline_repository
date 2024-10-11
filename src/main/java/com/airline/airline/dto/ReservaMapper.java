package com.airline.airline.dto;

import com.airline.airline.entities.Reserva;

public interface ReservaMapper {
    ReservaDTO toDTO(Reserva reserva);
    Reserva toEntity(ReservaDTO reservaDTO);
}
