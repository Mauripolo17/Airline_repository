package com.airline.airline.services;

import com.airline.airline.entities.Reserva;
import com.airline.airline.entities.Vuelo;

import java.util.List;
import java.util.Optional;

public class ReservaServiceImp implements ReservaService {
    @Override
    public Optional<Reserva> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Reserva> findAll() {
        return List.of();
    }

    @Override
    public Reserva updateReserva(Long id, Reserva reserva) {
        return null;
    }

    @Override
    public void deleteReserva(Long id) {

    }

    @Override
    public Optional<Reserva> findReservaByFlightId(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Reserva> findReservaByAirlineId(Long id) {
        return Optional.empty();
    }

    @Override
    public Reserva saveReserva(Reserva reserva) {
        return null;
    }

    @Override
    public List<Vuelo> findVueloByReserva(Long id) {
        return List.of();
    }
}
