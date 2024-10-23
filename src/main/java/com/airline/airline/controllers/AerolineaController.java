package com.airline.airline.controllers;

import com.airline.airline.dto.AerolineaDTO;
import com.airline.airline.entities.Aerolinea;
import com.airline.airline.security.services.AerolineaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aerolinea")
public class AerolineaController {

    private final AerolineaService aerolineaService;

    public AerolineaController(AerolineaService aerolineaService) {
        this.aerolineaService = aerolineaService;
    }

    @GetMapping
    public ResponseEntity<List<AerolineaDTO>> obtenerAerolinea() {
        return ResponseEntity.ok(aerolineaService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<AerolineaDTO> obtenerAerolineaPorId(@PathVariable("id") Long id) {
        return aerolineaService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AerolineaDTO> crearAerolinea(@RequestBody AerolineaDTO aerolinea) {
        return createAerolinea(aerolinea);
    }


    @PutMapping("/id")
    public ResponseEntity<AerolineaDTO> actualizarAerolinea(@PathVariable Long id, @RequestBody AerolineaDTO aerolinea) {
        Optional<AerolineaDTO> aerolineaUpdate = aerolineaService.update(id, aerolinea);
        return aerolineaUpdate.map(c -> ResponseEntity.ok(c)).orElseGet(() -> {
            return createAerolinea(aerolinea);
        });
    }

    private ResponseEntity<AerolineaDTO> createAerolinea(AerolineaDTO aerolinea) {
        AerolineaDTO newAerolinea = aerolineaService.save(aerolinea);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAerolinea.id()).toUri();
        return ResponseEntity.created(location).body(newAerolinea);
    }

    @DeleteMapping("/id")
    public ResponseEntity<AerolineaDTO> deleteAerolinea(@PathVariable Long id) {
           return aerolineaService.findById(id).map(a-> {
               aerolineaService.delete(id);
               return ResponseEntity.ok().body(a);
           }).orElse(ResponseEntity.notFound().build());
    }


}

