package com.airline.airline.services;

import com.airline.airline.entities.Aerolinea;
import com.airline.airline.repositories.AerolineaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AerolineaServiceImp implements AerolineaService {

    private final AerolineaRepository aerolineaRepository;
    public AerolineaServiceImp(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }


    @Override
    public Optional<Aerolinea> findById(Long id) {
        return aerolineaRepository.findById(id);
    }

    @Override
    public Optional<Aerolinea> findByName(String name) {
        return aerolineaRepository.findByNombre(name);
    }

    @Override
    public Aerolinea save(Aerolinea aerolinea) {
        aerolineaRepository.save(aerolinea);
        return aerolinea;
    }

    @Override
    public void delete(Long id) {
        aerolineaRepository.deleteById(id);
    }

    @Override
    public Optional<Aerolinea> update(Long id, Aerolinea newAerolinea) {
        return aerolineaRepository.findById(id).
                map(aerolineaInBD -> {
                    aerolineaInBD.setNombre(newAerolinea.getNombre());
                    aerolineaInBD.setCodigoAerolinea(newAerolinea.getCodigoAerolinea());
                    aerolineaInBD.setPaisOrigen(newAerolinea.getPaisOrigen());
                    aerolineaInBD.setVuelos(newAerolinea.getVuelos());

                    return aerolineaRepository.save(aerolineaInBD);
                }
        )
;
    }

    @Override
    public List<Aerolinea> findAll() {
        return aerolineaRepository.findAll();
    }
}
