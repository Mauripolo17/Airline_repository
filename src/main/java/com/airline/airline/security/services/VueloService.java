package com.airline.airline.security.services;

import com.airline.airline.dto.ReservaDTO;
import com.airline.airline.dto.VueloDTO;
import com.airline.airline.entities.Reserva;
import com.airline.airline.entities.Vuelo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VueloService {

    Optional<VueloDTO> findById(Long id);

    List<VueloDTO> findAll();

    VueloDTO saveVuelo(VueloDTO vuelo);

    List<String> getCiudadesDestino();

    Optional<VueloDTO> updateVuelo(Long id, VueloDTO vuelo);

    void deleteVuelo(Long id);

    List<Vuelo> saveAll(List<VueloDTO> vuelos);

    List<Reserva> findByVuelo(Long id);

    Optional<VueloDTO> findByReserva(Long id, ReservaDTO reserva);

    Vuelo findVueloById(Long id);
    List<Vuelo> getVuelosPorFecha(LocalDate fecha);

    Vuelo findByFecha(LocalDate fecha);

}
