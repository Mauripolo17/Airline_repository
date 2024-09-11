package com.airline.airline.services;

import com.airline.airline.entities.Aerolinea;

import java.util.List;
import java.util.Optional;

public class AerolineaServiceImp implements AerolineaService {
    @Override
    public Optional<Aerolinea> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Aerolinea> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Aerolinea> findAll() {
        return List.of();
    }

    @Override
    public Optional<Aerolinea> save(Aerolinea aerolinea) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Aerolinea> update(Long id, Aerolinea aerolinea) {
        return Optional.empty();
    }
}
