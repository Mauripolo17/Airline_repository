package com.airline.airline.services;

import com.airline.airline.entities.Aeropuerto;
import com.airline.airline.repositories.AeropuertoRepository;

import java.util.List;
import java.util.Optional;

public class AeropuertoServiceImp implements AeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;

    public AeropuertoServiceImp(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }


    @Override
    public Optional<Aeropuerto> findByName(String name) {
        Optional<Aeropuerto> aeroPuerto = findByName(name);
        return aeroPuerto;
    }

    @Override
    public Optional<Aeropuerto> findById(Long id) {
        Optional<Aeropuerto> aeroPuerto = findById(id);
        return aeroPuerto;
    }

    @Override
    public List<Aeropuerto> findAll() {
        return aeropuertoRepository.findAll();
    }

    @Override
    public void save(Aeropuerto aeropuerto) {
        aeropuertoRepository.save(aeropuerto);
    }

    @Override
    public void update(Aeropuerto aeropuerto) {
        aeropuertoRepository.save(aeropuerto);
    }

    @Override
    public void delete(Long id) {
        aeropuertoRepository.deleteById(id);
    }
}
