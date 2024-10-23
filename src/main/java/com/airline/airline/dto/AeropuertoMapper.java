package com.airline.airline.dto;

import com.airline.airline.entities.Aeropuerto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AeropuertoMapper {
    AeropuertoDTO toDTO(Aeropuerto aeropuerto);

    @Mapping(target = "id", ignore = true)
    AeropuertoDTO toDTOWithoutID(Aeropuerto aeropuerto);

    Aeropuerto toEntity(AeropuertoDTO aeropuertoDTO);
}
