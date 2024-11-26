package com.airline.airline.security.services;

import com.airline.airline.dto.PasajeroDTO;
import com.airline.airline.dto.PasajeroMapper;
import com.airline.airline.entities.Pasajero;
import com.airline.airline.repositories.PasajeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PasajeroServiceImp implements PasajeroService {

    private final PasajeroRepository pasajeroRepository;
    private final PasajeroMapper pasajeroMapper;
    private final ReservaService reservaService;

    public PasajeroServiceImp(PasajeroRepository pasajeroRepository, PasajeroMapper pasajeroMapper, ReservaService reservaService) {
        this.pasajeroRepository = pasajeroRepository;
        this.pasajeroMapper = pasajeroMapper;
        this.reservaService = reservaService;
    }


    @Override
    public Optional<PasajeroDTO> findByName(String nombre) {
        return pasajeroRepository.findByNombre(nombre).map(pasajeroMapper::toDTOWithoutId);
    }

    @Override
    public Optional<PasajeroDTO> findById(Long id) {
        return pasajeroRepository.findById(id).map(pasajeroMapper::toDTO);
    }

    @Override
    public Optional<PasajeroDTO> findByReserva(Long id) {
        return pasajeroRepository.findByReserva_Id(id).map(pasajeroMapper::toDTO);
    }

    @Override
    public PasajeroDTO savePasajero(PasajeroDTO pasajero) {
        Pasajero pasajeroEntity = pasajeroMapper.toEntity(pasajero, reservaService);
        return pasajeroMapper.toDTO(pasajeroRepository.save(pasajeroEntity));
    }

    @Override
    public void deletePasajero(Long id) {
        pasajeroRepository.deleteById(id);
    }

    @Override
    public List<PasajeroDTO> findAll() {
        return pasajeroRepository.findAll().stream().map(dto -> pasajeroMapper.toDTOWithoutId(dto)).collect(Collectors.toList());
    }

    @Override
    public List<PasajeroDTO> saveAll(List<PasajeroDTO> pasajeros) {
        List<Pasajero> pasajeroList = pasajeros.stream().map(p->pasajeroMapper.toEntity(p, reservaService)).collect(Collectors.toList());
        return pasajeroRepository.saveAll(pasajeroList).stream().map(dto -> pasajeroMapper.toDTO(dto)).collect(Collectors.toList());
    }

    @Override
    public Optional<PasajeroDTO> updatePasajero(Long id, PasajeroDTO newPasajero) {
        return pasajeroRepository.findById(id).
                map(pasajeroInBD-> {
                    pasajeroInBD.setNombre(newPasajero.nombre());
                    pasajeroInBD.setApellido(newPasajero.apellido());
                    pasajeroInBD.setFechaDeNacimiento(newPasajero.fechaDeNacimiento());
                    pasajeroInBD.setTipoDocumento(newPasajero.tipoDocumento());
                    pasajeroInBD.setNumeroDocumento(newPasajero.numeroDocumento());
                    pasajeroInBD.setSexo(newPasajero.sexo());
                    return pasajeroRepository.save(pasajeroInBD);
                }).map(pasajeroMapper::toDTO);
    }

}
