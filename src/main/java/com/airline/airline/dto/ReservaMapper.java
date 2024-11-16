package com.airline.airline.dto;

import com.airline.airline.entities.Cliente;
import com.airline.airline.entities.Cliente;
import com.airline.airline.entities.Reserva;
import com.airline.airline.security.services.ClienteService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    @Mapping(target = "cliente", source = "cliente.id")
    ReservaDTO toDTO(Reserva reserva);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", source = "cliente.id")
    ReservaDTO toDTOWithoutId(Reserva reserva);
    @Mapping(source = "cliente", target = "cliente", qualifiedByName = "IdToCliente")
    Reserva toEntity(ReservaDTO reservaDTO, @Context ClienteService clienteService);

    @Named("IdToCliente")
    default Cliente mapIdToCliente(Long id, @Context ClienteService clienteService) {
        return id != null ? clienteService.findClienteById(id).orElse(null): null;
    }

}
