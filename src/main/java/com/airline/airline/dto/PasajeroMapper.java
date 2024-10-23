package com.airline.airline.dto;

import com.airline.airline.entities.Pasajero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PasajeroMapper {
    PasajeroDTO toDTO(Pasajero pasajero);

    @Mapping(target = "id", ignore = true)
    PasajeroDTO toDTOWithoutId(Pasajero pasajero);

    Pasajero toEntity(PasajeroDTO pasajeroDTO);
}
