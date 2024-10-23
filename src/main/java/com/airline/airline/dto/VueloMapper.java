package com.airline.airline.dto;

import com.airline.airline.entities.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VueloMapper {
    @Mapping(target = "aerolineaId", source = "aerolinea.id")
    @Mapping(target = "aeropuertoId", source = "aeropuerto.id")
    VueloDTO toDTO(Vuelo vuelo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aerolineaId", source = "aerolinea.id")
    @Mapping(target = "aeropuertoId", source = "aeropuerto.id")
    VueloDTO toDTOWithoutId(Vuelo vuelo);

    @Mapping(target = "aerolinea.id", source = "aerolineaId")
    @Mapping(target = "aeropuerto.id", source = "aeropuertoId")
    Vuelo toEntity(VueloDTO vueloDTO);
}
