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
    public Optional<Pasajero> findByName(String nombre) {
        return Optional.empty();
    }

    @Override
    public Optional<Pasajero> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Pasajero> findByReserva(Long id) {
        return Optional.empty();
    }

    @Override
    public void savePasajero(Pasajero pasajero) {

    }

    @Override
    public void deletePasajero(Long id) {

    }

    @Override
    public List<Pasajero> findAll() {
        return null;
    }

    @Override
    public Optional<Pasajero> updatePasajero(Long id, Pasajero newPasajero) {
        return pasajeroRepository.findById(id).
                map(pasajeroInBD-> {
                    pasajeroInBD.setNombre(newPasajero.getNombre());
                    pasajeroInBD.setApellido(newPasajero.getApellido());
                    pasajeroInBD.setFechaDeNacimiento(newPasajero.getFechaDeNacimiento());
                    pasajeroInBD.setTipoDocumento(newPasajero.getTipoDocumento());
                    pasajeroInBD.setNumeroDocumento(newPasajero.getNumeroDocumento());

                    return pasajeroRepository.save(pasajeroInBD);
                });
    }

}
