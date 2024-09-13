package com.airline.airline.services;

import com.airline.airline.entities.Pasajero;
import com.airline.airline.repositories.PasajeroRepository;

import java.util.List;
import java.util.Optional;

public class PasajeroServiceImp implements PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    public PasajeroServiceImp(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    @Override
    public Optional<Pasajero> buscarPasajeroPorNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    public Optional<Pasajero> buscarPasajeroPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Pasajero guardarPasajero(Pasajero pasajero) {
        return null;
    }

    @Override
    public void eliminarPasajero(Long id) {

    }

    @Override
    public List<Pasajero> listarPasajeros() {
        return List.of();
    }

    @Override
    public Optional<Pasajero> actualizarPasajero(Long id, Pasajero pasajero) {
        return Optional.empty();
    }

    @Override
    public List<Pasajero> findPasajeroByReserva(Long id) {
        return List.of();
    }
}
