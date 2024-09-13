package com.airline.airline.services;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.airline.airline.entities.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface AeropuertoService {

    Optional<Aeropuerto> findByName(String name);

    Optional<Aeropuerto> findById(Long id);

    List<Aeropuerto> findAll();

    void save(Aeropuerto aeropuerto);

    void update(Aeropuerto aeropuerto);

    void delete(Long id);

}
