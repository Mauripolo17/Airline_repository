package com.airline.airline.security.services;

import com.airline.airline.dto.AerolineaDTO;
import com.airline.airline.dto.AerolineaMapper;
import com.airline.airline.entities.Aerolinea;
import com.airline.airline.repositories.AerolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AerolineaServiceImp implements AerolineaService {

    private final AerolineaRepository aerolineaRepository;

    private final AerolineaMapper aerolineaMapper;


    public AerolineaServiceImp(AerolineaRepository aerolineaRepository, AerolineaMapper aerolineaMapper) {
        this.aerolineaRepository = aerolineaRepository;
        this.aerolineaMapper = aerolineaMapper;
    }


    @Override
    public Optional<AerolineaDTO> findById(Long id) {
        return aerolineaRepository.findById(id)
                .map(aerolineaMapper::toDTOWithoutId);
    }


    @Override
    public Optional<AerolineaDTO> findByName(String name) {
        return aerolineaRepository.findByNombre(name).map(aerolineaMapper::toDTOWithoutId);
    }

    @Override
    public AerolineaDTO save(AerolineaDTO aerolineaDTO) {
        Aerolinea aerolinea = aerolineaRepository.save(aerolineaMapper.toEntity(aerolineaDTO));
        return aerolineaMapper.toDTO(aerolinea);
    }

    @Override
    public void delete(Long id) {
        aerolineaRepository.deleteById(id);
    }

    @Override
    public Optional<AerolineaDTO> update(Long id, AerolineaDTO newAerolinea) {
        return aerolineaRepository.findById(id).
                map(aerolineaInBD -> {
                            aerolineaInBD.setNombre(newAerolinea.nombre());
                            aerolineaInBD.setCodigoAerolinea(newAerolinea.codigoAerolinea());
                            aerolineaInBD.setPaisOrigen(newAerolinea.paisOrigen());
                            return aerolineaRepository.save(aerolineaInBD);
                        }
                ).map(aerolineaMapper::toDTO);

    }

    @Override
    public List<AerolineaDTO> findAll() {
        return aerolineaRepository.findAll().stream().map(dto -> aerolineaMapper.toDTO(dto)).collect(Collectors.toList());
    }
}
