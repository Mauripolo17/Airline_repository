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

    void updateReserva(Reserva reserva);

    void deleteReserva(Long id);

    Optional<Reserva> findByFlightId(Long id);

    Optional<Reserva> findByAirlineId(Long id);

    Optional<Reserva> findByReserva(Long id);

    void saveReserva(Reserva reserva);



}
