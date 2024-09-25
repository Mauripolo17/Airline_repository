package com.airline.airline.services;

import com.airline.airline.entities.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    Optional<Reserva> findById(Long id);

    List<Reserva> findAll();

    Optional<Reserva> updateReserva(Long id, Reserva reserva);

    void deleteReserva(Long id);

    Optional<Reserva> findByFlightId(Long id);

    Optional<Reserva> findByAirlineId(Long id);


    Reserva saveReserva(Reserva reserva);



}
