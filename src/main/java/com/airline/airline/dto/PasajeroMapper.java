package com.airline.airline.dto;

import com.airline.airline.entities.Pasajero;
import com.airline.airline.entities.Reserva;
import com.airline.airline.security.services.PasajeroService;
import com.airline.airline.security.services.ReservaService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PasajeroMapper {
    @Mapping(source = "reserva.id", target = "reserva")
    PasajeroDTO toDTO(Pasajero pasajero);
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "reserva.id", target = "reserva")
    PasajeroDTO toDTOWithoutId(Pasajero pasajero);
    @Mapping(source = "reserva", target = "reserva", qualifiedByName = "IdToReserva")
    Pasajero toEntity(PasajeroDTO pasajeroDTO, @Context ReservaService reservaService);

    @Named("IdToReserva")
    default Reserva mapIdToReserva(Long id, @Context ReservaService reservaService) {
        return id != null ? reservaService.findReservaById(id): null;
    }
}
