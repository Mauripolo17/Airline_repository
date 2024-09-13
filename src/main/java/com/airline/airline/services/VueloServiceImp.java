package com.airline.airline.services;

import com.airline.airline.entities.Reserva;
import com.airline.airline.entities.Vuelo;
import com.airline.airline.repositories.VueloRepository;

import java.util.List;
import java.util.Optional;

public class VueloServiceImp implements VueloService {

    private final VueloRepository vueloRepository;

    public VueloServiceImp(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public Optional<Vuelo> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Vuelo> findAll() {
        return List.of();
    }

    @Override
    public Vuelo saveVuelo(Vuelo vuelo) {
        return null;
    }

    @Override
    public Optional<Vuelo> updateVuelo(Long id, Vuelo vuelo) {
        return Optional.empty();
    }

    @Override
    public void deleteVuelo(Long id) {

    }

    @Override
    public List<Reserva> findByVuelo(Long id) {
        return List.of();
    }

    @Override
    public Optional<Vuelo> findByVueloAndReserva(Long id, Reserva reserva) {
        return Optional.empty();
    }
}
