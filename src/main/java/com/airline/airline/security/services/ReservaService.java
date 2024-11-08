package com.airline.airline.security.services;

import com.airline.airline.dto.ReservaDTO;
import com.airline.airline.entities.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    Optional<ReservaDTO> findById(Long id);

    List<ReservaDTO> findAll();

    Optional<ReservaDTO> updateReserva(Long id, ReservaDTO reserva);

    void deleteReserva(Long id);

    Optional<ReservaDTO> findByFlightId(Long id);

    ReservaDTO saveReserva(ReservaDTO reserva);

    Reserva findReservaById(Long id);



}
