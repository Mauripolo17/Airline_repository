package com.airline.airline.services;

import com.airline.airline.entities.Pasajero;

import java.util.List;
import java.util.Optional;

public interface PasajeroService {

    Optional<Pasajero> findByName(String nombre);

    Optional<Pasajero> findById(Long id);

    Optional<Pasajero> findByReserva(Long id);

    void savePasajero(Pasajero pasajero);

    void deletePasajero(Long id);

    List<Pasajero> findAll();

    Optional<Pasajero> updatePasajero(Long id, Pasajero pasajero);


}
