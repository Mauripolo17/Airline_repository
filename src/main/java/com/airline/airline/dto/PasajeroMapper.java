package com.airline.airline.dto;

import com.airline.airline.entities.Pasajero;
import org.mapstruct.Mapper;

@Mapper
public interface PasajeroMapper {
    PasajeroDTO toDTO(Pasajero pasajero);
    Pasajero toEntity(PasajeroDTO pasajeroDTO);
}
