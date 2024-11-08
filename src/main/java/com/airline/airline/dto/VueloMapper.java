package com.airline.airline.dto;

import com.airline.airline.entities.Aerolinea;
import com.airline.airline.entities.Aeropuerto;
import com.airline.airline.entities.Vuelo;
import com.airline.airline.security.services.AeropuertoService;
import com.airline.airline.security.services.AerolineaService;
import com.airline.airline.security.services.VueloService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Mapper(componentModel = "spring")
public interface VueloMapper {
    @Mapping(target = "aerolinea", source = "aerolinea.id")
    @Mapping(target = "aeropuerto", source = "aeropuerto.id")
    VueloDTO toDTO(Vuelo vuelo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aerolinea", source = "aerolinea.id")
    @Mapping(target = "aeropuerto", source = "aeropuerto.id")
    VueloDTO toDTOWithoutId(Vuelo vuelo);

    @Mapping(source = "aerolinea", target = "aerolinea", qualifiedByName = "idToAerolinea")
    @Mapping(source = "aeropuerto", target = "aeropuerto", qualifiedByName = "idToAeropuerto")
    Vuelo toEntity(VueloDTO vueloDTO, @Context AerolineaService aerolineaService, @Context AeropuertoService aeropuertoService);

    @Named("idToAerolinea")
    default Aerolinea mapIdToAerolinea(Long id, @Context AerolineaService aerolineaService) {
        return id != null ? aerolineaService.findAerolineaById(id): null;
    }

    @Named("idToAeropuerto")
    default Aeropuerto mapIdToAeropuerto(Long id, @Context AeropuertoService aeropuertoService) {
        return id != null ? aeropuertoService.findAeropuertoById(id): null;
    }
}
