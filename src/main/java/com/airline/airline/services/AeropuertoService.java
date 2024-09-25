package com.airline.airline.services;

import com.airline.airline.entities.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface AeropuertoService {

    Optional<Aeropuerto> findByName(String name);

    Optional<Aeropuerto> findById(Long id);

    List<Aeropuerto> findAll();

    Aeropuerto save(Aeropuerto aeropuerto);

    Optional<Aeropuerto> update(Long id, Aeropuerto aeropuerto);

    void delete(Long id);
    List<Aeropuerto> findAll(String name);

}
