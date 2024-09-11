package com.airline.airline.services;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.airline.airline.entities.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface AeropuertoService {

    Optional<Aeropuerto> buscarAeropuertoPorNombre(String nombre);

    Optional<Aeropuerto> buscarAeropuertoPorId(Long id);

    List<Aeropuerto> listarAeropuertos();

    Aeropuerto guardarAeropuerto(Aeropuerto aeropuerto);

    Optional<Aeropuerto> actualizarAeropuerto(Long id, Aeropuerto actual);

    void eliminarAeropuerto(Long id);


}
