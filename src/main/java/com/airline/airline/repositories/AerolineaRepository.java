package com.airline.airline.repositories;


import com.airline.airline.dto.AerolineaDTO;
import com.airline.airline.entities.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {

    Optional<Aerolinea> findByNombre(String name);
}
