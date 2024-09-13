package com.airline.airline.services;

import aj.org.objectweb.asm.Opcodes;
import com.airline.airline.entities.Aerolinea;

import java.util.List;
import java.util.Optional;

public interface AerolineaService {

    Optional<Aerolinea> findById(Long id);

    Optional<Aerolinea> findByName(String name);

    void save(Aerolinea aerolinea);

    void delete(Long id);

    Optional<Aerolinea> update(Long id, Aerolinea aerolinea);

}
