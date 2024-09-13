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
        return vueloRepository.findById(id);
    }

    @Override
    public List<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    @Override
    public void saveVuelo(Vuelo vuelo) {
        vueloRepository.save(vuelo);
    }
    @Override
    public Optional<Vuelo> updateVuelo(Long id, Vuelo vuelo) {
        return vueloRepository.findById(id).map(vueloInBD->{
            vueloInBD.setCapacidad(vuelo.getCapacidad());
            vueloInBD.setDestino(vuelo.getDestino());
            vueloInBD.setOrigen(vuelo.getOrigen());
            vueloInBD.setFechaDeSalida(vuelo.getFechaDeSalida());
            vueloInBD.setHoraDeSalida(vuelo.getHoraDeSalida());
            vueloInBD.setDuracion(vuelo.getDuracion());
            vueloInBD.setReservas(vuelo.getReservas());

            return vueloRepository.save(vueloInBD);
        });
    }
    @Override
    public void deleteVuelo(Long id) {
        vueloRepository.deleteById(id);
    }
    @Override
    public List<Reserva> findByVuelo(Long id) {
        return vueloRepository.findByVuelo(id);
    }

    @Override
    public Optional<Vuelo> findByReserva(Long id, Reserva reserva) {
        return vueloRepository.findByReserva(id);
    }

}
