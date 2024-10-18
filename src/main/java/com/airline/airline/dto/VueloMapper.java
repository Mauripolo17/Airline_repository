package com.airline.airline.dto;

import com.airline.airline.entities.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VueloMapper {

    VueloDTO toDTO(Vuelo vuelo);
    Vuelo toEntity(VueloDTO vueloDTO);
}
