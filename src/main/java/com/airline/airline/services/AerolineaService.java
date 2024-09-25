package com.airline.airline.services;

import com.airline.airline.entities.Aerolinea;

import java.util.List;
import java.util.Optional;

public interface AerolineaService {

    Optional<Aerolinea> findById(Long id);

    Optional<Aerolinea> findByName(String name);

    Aerolinea save(Aerolinea aerolinea);

    void delete(Long id);

    Optional<Aerolinea> update(Long id, Aerolinea aerolinea);

    List<Aerolinea> findAll();

}
