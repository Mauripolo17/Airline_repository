package com.airline.airline.dto;

import com.airline.airline.entities.Cliente;
import com.airline.airline.entities.Pasajero;
import com.airline.airline.entities.Vuelo;

import java.util.Date;
import java.util.Set;

public record ReservaDTO(Long id, Date fechaReserva, Cliente cliente, Set<Pasajero> pasajeros, Set<Vuelo> vuelos) {
}
