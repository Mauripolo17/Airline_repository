package com.airline.airline.security.services;

import com.airline.airline.dto.AeropuertoDTO;
import com.airline.airline.dto.AeropuertoMapper;
import com.airline.airline.entities.Aeropuerto;
import com.airline.airline.repositories.AeropuertoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AeropuertoServiceImp implements AeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;
    private final AeropuertoMapper aeropuertoMapper;

    public AeropuertoServiceImp(AeropuertoRepository aeropuertoRepository, AeropuertoMapper aeropuertoMapper) {
        this.aeropuertoRepository = aeropuertoRepository;
        this.aeropuertoMapper = aeropuertoMapper;
    }


    @Override
    public Optional<AeropuertoDTO> findByName(String name) {
        return aeropuertoRepository.findByNombre(name).map(aeropuertoMapper::toDTOWithoutID);
    }

    @Override
    public Optional<AeropuertoDTO> findById(Long id) {
        return aeropuertoRepository.findById(id).map(aeropuertoMapper::toDTOWithoutID);
    }

    @Override
    public List<AeropuertoDTO> findAll() {
        return aeropuertoRepository.findAll().stream().map(dto -> aeropuertoMapper.toDTOWithoutID(dto)).collect(Collectors.toList());
    }

    @Override
    public AeropuertoDTO save(AeropuertoDTO aeropuertoDTO) {
        Aeropuerto aeropuertoEntity = aeropuertoMapper.toEntity(aeropuertoDTO);
        return aeropuertoMapper.toDTO(aeropuertoRepository.save(aeropuertoEntity));
    }

    @Override
    public Optional<AeropuertoDTO> update(Long id, AeropuertoDTO newAeropuerto) {
        return aeropuertoRepository.findById(id).
                map(aeropuertoInBD-> {
                    aeropuertoInBD.setNombre(newAeropuerto.nombre());
                    aeropuertoInBD.setCiudad(newAeropuerto.ciudad());
                    aeropuertoInBD.setPais(newAeropuerto.pais());
                    return aeropuertoRepository.save(aeropuertoInBD);
                }).map(aeropuertoMapper::toDTO);
    }

    @Override
    public void delete(Long id) {
        aeropuertoRepository.deleteById(id);
    }

    @Override
    public List<AeropuertoDTO> findAll(String name) {
        return aeropuertoRepository.findAll().stream().map(dto -> aeropuertoMapper.toDTOWithoutID(dto)).collect(Collectors.toList());
    }

    @Override
    public Aeropuerto findAeropuertoById(Long id) {
        return aeropuertoRepository.findById(id).orElse(null);
    }
}
