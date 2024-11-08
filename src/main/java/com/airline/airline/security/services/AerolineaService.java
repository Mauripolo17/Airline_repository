package com.airline.airline.security.services;

import com.airline.airline.dto.AerolineaDTO;
import com.airline.airline.entities.Aerolinea;

import java.util.List;
import java.util.Optional;

public interface AerolineaService {

    Optional<AerolineaDTO> findById(Long id);

    Optional<AerolineaDTO> findByName(String name);

    AerolineaDTO save(AerolineaDTO aerolinea);

    void delete(Long id);

    Optional<AerolineaDTO> update(Long id, AerolineaDTO aerolinea);

    List<AerolineaDTO> findAll();

    Aerolinea findAerolineaById(Long id);
}
