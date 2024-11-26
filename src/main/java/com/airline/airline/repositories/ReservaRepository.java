package com.airline.airline.repositories;

import com.airline.airline.dto.PasajeroDTO;
import com.airline.airline.entities.Pasajero;
import com.airline.airline.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Optional<Reserva> findByVuelos_Id(Long id);
    List<Pasajero> findPasajerosByReserva_Id(Long id);

}
