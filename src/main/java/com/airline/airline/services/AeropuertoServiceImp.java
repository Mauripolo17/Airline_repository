package com.airline.airline.services;

import com.airline.airline.entities.Aeropuerto;

import java.util.List;
import java.util.Optional;

public class AeropuertoServiceImp implements AeropuertoService {
    @Override
    public Optional<Aeropuerto> buscarAeropuertoPorNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    public Optional<Aeropuerto> buscarAeropuertoPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Aeropuerto> listarAeropuertos() {
        return List.of();
    }

    @Override
    public Aeropuerto guardarAeropuerto(Aeropuerto aeropuerto) {
        return null;
    }

    @Override
    public Optional<Aeropuerto> actualizarAeropuerto(Long id, Aeropuerto actual) {
        return Optional.empty();
    }

    @Override
    public void eliminarAeropuerto(Long id) {

    }
}
