package com.airline.airline.services;

import com.airline.airline.entities.Reserva;
import com.airline.airline.entities.Vuelo;
import com.airline.airline.repositories.ReservaRepository;

import java.util.List;
import java.util.Optional;

public class ReservaServiceImp implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImp(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Reserva> findAll() {
        return List.of();
    }

    @Override
    public void updateReserva(Reserva reserva) {

    }


    @Override
    public void deleteReserva(Long id) {

    }

    @Override
    public Optional<Reserva> findByFlightId(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Reserva> findByAirlineId(Long id) {
        return Optional.empty();
    }


    @Override
    public void saveReserva(Reserva reserva) {

    }

    @Override
    public Optional<Reserva> findByReserva(Long id) {
        return Optional.empty();
    }


}
