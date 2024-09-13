package com.airline.airline.repositories;

import com.airline.airline.entities.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
    Optional<Pasajero> findByReserva(Long id);
    Optional<Pasajero> findByName(String nombre);
}
