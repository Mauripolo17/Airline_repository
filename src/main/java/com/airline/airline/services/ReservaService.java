package com.airline.airline.services;

import com.airline.airline.entities.Pasajero;
import com.airline.airline.entities.Reserva;
import com.airline.airline.entities.Vuelo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ReservaService {

    Optional<Reserva> findById(String id);

    List<Reserva> findAll();

    Reserva updateReserva(Long id, Reserva reserva);

    void deleteReserva(String id);

    Optional<Reserva> findReservaByFlightId(String id);

    Optional<Reserva> findReservaByAirlineId(String id);

    Reserva saveReserva(Reserva reserva);

    List<Vuelo> findVueloByReserva(Long id);

}
