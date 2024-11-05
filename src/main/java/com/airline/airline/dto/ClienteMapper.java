package com.airline.airline.dto;

import com.airline.airline.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente cliente);

    @Mapping(target = "id", ignore = true)
    ClienteDTO toDTOWithoutId(Cliente cliente);

    Cliente toEntity(ClienteDTO clienteDTO);
}
