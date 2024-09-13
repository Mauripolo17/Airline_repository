package com.airline.airline.repositories;

import com.airline.airline.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Optional<Reserva> findByFlightId(Long id);

    Optional<Reserva> findByAirlineId(Long id);

    Optional<Reserva> findByReserva(Long id);

}
