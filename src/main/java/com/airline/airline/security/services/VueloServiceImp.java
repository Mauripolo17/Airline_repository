package com.airline.airline.security.services;

import com.airline.airline.dto.ReservaDTO;
import com.airline.airline.dto.VueloDTO;
import com.airline.airline.dto.VueloMapper;
import com.airline.airline.entities.Aerolinea;
import com.airline.airline.entities.Reserva;
import com.airline.airline.entities.Vuelo;
import com.airline.airline.repositories.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VueloServiceImp implements VueloService {

    private final VueloRepository vueloRepository;
    private final VueloMapper vueloMapper;
    private final AerolineaService aerolineaService;
    private final AeropuertoService aeropuertoService;

    public VueloServiceImp(VueloRepository vueloRepository, VueloMapper vueloMapper, AerolineaService aerolineaService, AeropuertoService aeropuertoService) {
        this.vueloRepository = vueloRepository;
        this.vueloMapper = vueloMapper;
        this.aerolineaService = aerolineaService;
        this.aeropuertoService = aeropuertoService;
    }

    @Override
    public Optional<VueloDTO> findById(Long id) {
        return vueloRepository.findById(id).map(vueloMapper::toDTO);
    }

    @Override
    public List<VueloDTO> findAll() {
        return vueloRepository.findAll().stream().map(vueloMapper::toDTO).collect(Collectors.toList());
    }


    @Override
    public VueloDTO saveVuelo(VueloDTO vuelo) {
        Vuelo vueloEntity = vueloMapper.toEntity(vuelo, aerolineaService, aeropuertoService);
        return vueloMapper.toDTO(vueloRepository.save(vueloEntity));
    }

    @Override
    public List<String> getCiudadesDestino() {
        return vueloRepository.findCiudadesDestino();
    }

    @Override
    public Optional<VueloDTO> updateVuelo(Long id, VueloDTO vuelo) {
        return vueloRepository.findById(id).map(vueloInBD->{
            vueloInBD.setCapacidad(vuelo.capacidad());
            vueloInBD.setDestino(vuelo.destino());
            vueloInBD.setOrigen(vuelo.origen());
            vueloInBD.setFechaDeSalida(vuelo.fechaDeSalida());
            vueloInBD.setHoraDeSalida(vuelo.horaDeSalida());
            vueloInBD.setDuracion(vuelo.duracion());
            vueloInBD.setAerolinea(aerolineaService.findAerolineaById(vuelo.aerolinea()));
            vueloInBD.setAeropuerto(aeropuertoService.findAeropuertoById(vuelo.aeropuerto()));

            return vueloRepository.save(vueloInBD);
        }).map(vueloMapper::toDTO);
    }
    @Override
    public void deleteVuelo(Long id) {
        vueloRepository.deleteById(id);
    }

    @Override
    public List<Vuelo> saveAll(List<VueloDTO> vuelos) {
        return vueloRepository.saveAll(vuelos.stream().map(vueloDTO -> vueloMapper.toEntity(vueloDTO, aerolineaService, aeropuertoService)).collect(Collectors.toList()));
    }

    @Override
    public List<Reserva> findByVuelo(Long id) {
        return vueloRepository.findReservasById(id);
    }

    @Override
    public Optional<VueloDTO> findByReserva(Long id, ReservaDTO reserva) {

        return vueloRepository.findByReservas_Id(id).map(vueloMapper::toDTO);
    }

    @Override
    public Vuelo findVueloById(Long id) {
        return vueloRepository.findById(id).orElse(null);
    }

}
