package com.airline.airline.security.services;

import com.airline.airline.dto.AeropuertoDTO;
import com.airline.airline.entities.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface AeropuertoService {

    Optional<AeropuertoDTO> findByName(String name);

    Optional<AeropuertoDTO> findById(Long id);

    List<AeropuertoDTO> findAll();

    AeropuertoDTO save(AeropuertoDTO aeropuerto);

    Optional<AeropuertoDTO> update(Long id, AeropuertoDTO aeropuerto);

    void delete(Long id);
    List<AeropuertoDTO> findAll(String name);

    Aeropuerto findAeropuertoById(Long id);

}
