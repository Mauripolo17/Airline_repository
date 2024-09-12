package com.airline.airline.services;

import com.airline.airline.entities.Pasajero;
import com.airline.airline.entities.Reserva;
import com.airline.airline.entities.Vuelo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ReservaService {

    Optional<Reserva> findById(Long id);

    List<Reserva> findAll();

    Reserva updateReserva(Long id, Reserva reserva);

    void deleteReserva(Long id);

    Optional<Reserva> findReservaByFlightId(Long id);

    Optional<Reserva> findReservaByAirlineId(Long id);

    Reserva saveReserva(Reserva reserva);

    List<Vuelo> findVueloByReserva(Long id);

}
