package com.airline.airline.dto;

import com.airline.airline.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(source = "password", target = "password", ignore = true)
    ClienteDTO toDTO(Cliente cliente);
    @Mapping(source = "password", target = "password", ignore = true)
    @Mapping(target = "id", ignore = true)
    ClienteDTO toDTOWithoutId(Cliente cliente);

    Cliente toEntity(ClienteDTO clienteDTO);
}
