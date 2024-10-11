package com.airline.airline.dto;

import com.airline.airline.entities.Pasajero;

public interface PasajeroMapper {
    PasajeroDTO toDTO(Pasajero pasajero);
    Pasajero toEntity(PasajeroDTO pasajeroDTO);
}
