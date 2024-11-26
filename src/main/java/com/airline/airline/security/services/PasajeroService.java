package com.airline.airline.security.services;

import com.airline.airline.dto.PasajeroDTO;
import com.airline.airline.entities.Pasajero;

import java.util.List;
import java.util.Optional;

public interface PasajeroService {

    Optional<PasajeroDTO> findByName(String nombre);

    Optional<PasajeroDTO> findById(Long id);

    Optional<PasajeroDTO> findByReserva(Long id);

    PasajeroDTO savePasajero(PasajeroDTO pasajero);

    void deletePasajero(Long id);

    List<PasajeroDTO> findAll();

    List<PasajeroDTO> saveAll(List<PasajeroDTO> pasajeros);
    Optional<PasajeroDTO> updatePasajero(Long id, PasajeroDTO pasajero);


}
