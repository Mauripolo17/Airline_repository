package com.airline.airline.repositories;

import com.airline.airline.entities.Reserva;
import com.airline.airline.entities.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    List<Reserva> findByVuelo(Long id);

    Optional<Vuelo> findByReserva(Long id);
}
