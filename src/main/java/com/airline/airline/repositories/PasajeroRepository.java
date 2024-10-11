package com.airline.airline.repositories;

import com.airline.airline.entities.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
    Optional<Pasajero> findByReserva_Id(Long id);
    Optional<Pasajero> findByNombre(String nombre);
}
