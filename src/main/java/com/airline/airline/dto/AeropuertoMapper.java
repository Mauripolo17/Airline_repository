package com.airline.airline.dto;

import com.airline.airline.entities.Aeropuerto;
import org.mapstruct.Mapper;

@Mapper
public interface AeropuertoMapper {
    AeropuertoDTO toDTO(Aeropuerto aeropuerto);
}
