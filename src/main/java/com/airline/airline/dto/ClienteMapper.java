package com.airline.airline.dto;

import com.airline.airline.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente cliente);
    Cliente toEntity(ClienteDTO clienteDTO);
}
