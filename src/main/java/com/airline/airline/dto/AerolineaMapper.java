package com.airline.airline.dto;

import com.airline.airline.entities.Aerolinea;
import org.mapstruct.Mapper;

@Mapper
public interface AerolineaMapper {

    AerolineaDTO toDTO(Aerolinea aerolinea);
    Aerolinea toEntity(AerolineaDTO aerolineaDTO);
}

