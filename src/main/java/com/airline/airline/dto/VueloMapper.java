package com.airline.airline.dto;

import com.airline.airline.entities.Vuelo;

public interface VueloMapper {
    VueloDTO toDTO(Vuelo vuelo);
    Vuelo toEntity(VueloDTO vueloDTO);
}
