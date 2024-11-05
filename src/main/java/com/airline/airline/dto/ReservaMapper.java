package com.airline.airline.dto;

import com.airline.airline.entities.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    ReservaDTO toDTO(Reserva reserva);

    @Mapping(target = "id", ignore = true)
    ReservaDTO toDTOWithoutId(Reserva reserva);
    Reserva toEntity(ReservaDTO reservaDTO);
}
