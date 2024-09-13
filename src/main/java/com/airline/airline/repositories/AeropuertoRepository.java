package com.airline.airline.repositories;

import com.airline.airline.entities.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
    Optional<Aeropuerto> findByName(String name);
}
