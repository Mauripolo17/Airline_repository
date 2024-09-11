package com.airline.airline.services;

import com.airline.airline.entities.Pasajero;

import java.util.List;
import java.util.Optional;

public interface PasajeroService {

    Optional<Pasajero> buscarPasajeroPorNombre(String nombre);

    Optional<Pasajero> buscarPasajeroPorId(Long id);

    Pasajero guardarPasajero(Pasajero pasajero);

    void eliminarPasajero(Long id);

    List<Pasajero> listarPasajeros();

    Optional<Pasajero> actualizarPasajero(Long id, Pasajero pasajero);
}
