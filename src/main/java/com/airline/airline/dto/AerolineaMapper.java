package com.airline.airline.dto;

import com.airline.airline.entities.Aerolinea;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AerolineaMapper {

    AerolineaDTO toDTO(Aerolinea aerolinea);
    @Mapping(target = "id", ignore = true)
    AerolineaDTO toDTOWithoutId(Aerolinea aerolinea);
    Aerolinea toEntity(AerolineaDTO aerolineaDTO);


}

