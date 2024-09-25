package com.airline.airline.services;

import com.airline.airline.entities.Reserva;
import com.airline.airline.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservaServiceImp implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImp(ReservaRepository reservaRepository) {

        this.reservaRepository = reservaRepository;
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public List<Reserva> findAll() {

        return reservaRepository.findAll();
    }



    public Optional<Reserva> updateReserva(Long id, Reserva reserva) {
        return reservaRepository.findById(id).map(reservaInBD->{
            reservaInBD.setCliente(reserva.getCliente());
            reservaInBD.setFechaReserva(reserva.getFechaReserva());
            reservaInBD.setPasajeros(reserva.getPasajeros());
            reservaInBD.setVuelos(reserva.getVuelos());

            return reservaRepository.save(reservaInBD);
        });
    }


    @Override
    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public Optional<Reserva> findByFlightId(Long id) {
        return reservaRepository.findByFlightId(id);
    }

    @Override
    public Optional<Reserva> findByAirlineId(Long id) {
        return reservaRepository.findByAirlineId(id);
    }


    @Override
    public Reserva saveReserva(Reserva reserva) {
        reservaRepository.save(reserva);
        return reserva;
    }



}
