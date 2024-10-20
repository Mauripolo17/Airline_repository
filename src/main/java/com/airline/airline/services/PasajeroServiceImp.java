package com.airline.airline.services;

import com.airline.airline.entities.Pasajero;
import com.airline.airline.repositories.PasajeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PasajeroServiceImp implements PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    public PasajeroServiceImp(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }


    @Override
    public Optional<Pasajero> findByName(String nombre) {
        return pasajeroRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Pasajero> findById(Long id) {
        return pasajeroRepository.findById(id);
    }

    @Override
    public Optional<Pasajero> findByReserva(Long id) {
        return pasajeroRepository.findByReserva_Id(id);
    }

    @Override
    public Pasajero savePasajero(Pasajero pasajero) {
        pasajeroRepository.save(pasajero);
        return pasajero;
    }

    @Override
    public void deletePasajero(Long id) {
        pasajeroRepository.deleteById(id);
    }

    @Override
    public List<Pasajero> findAll() {
        return pasajeroRepository.findAll();
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
