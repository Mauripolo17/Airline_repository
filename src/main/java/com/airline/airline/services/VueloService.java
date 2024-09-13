package com.airline.airline.services;

import com.airline.airline.entities.Reserva;
import com.airline.airline.entities.Vuelo;

import java.util.List;
import java.util.Optional;

public interface VueloService {

    Optional<Vuelo> findById(Long id);

    List<Vuelo> findAll();

    void saveVuelo(Vuelo vuelo);

    void updateVuelo(Vuelo vuelo);

    void deleteVuelo(Long id);

    List<Reserva> findByVuelo(Long id);

    Optional<Vuelo> findByReserva(Long id, Reserva reserva);


}
