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
        return aeropuertoRepository.findByName(name);
    }

    @Override
    public Optional<Aeropuerto> findById(Long id) {
        return aeropuertoRepository.findById(id);
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
    public Optional<Aeropuerto> update(Long id, Aeropuerto newAeropuerto) {
        return aeropuertoRepository.findById(id).
                map(aeropuertoInBD-> {
                    aeropuertoInBD.setNombre(newAeropuerto.getNombre());
                    aeropuertoInBD.setCiudad(newAeropuerto.getCiudad());
                    aeropuertoInBD.setPais(newAeropuerto.getPais());
                    aeropuertoInBD.setVuelos(newAeropuerto.getVuelos());

                    return aeropuertoRepository.save(aeropuertoInBD);
                });
    }

    @Override
    public void delete(Long id) {
        aeropuertoRepository.deleteById(id);
    }
}
