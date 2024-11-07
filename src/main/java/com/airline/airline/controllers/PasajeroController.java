package com.airline.airline.controllers;

import com.airline.airline.dto.PasajeroDTO;
import com.airline.airline.entities.Pasajero;
import com.airline.airline.exceptions.PasajeroNotFoundException;
import com.airline.airline.security.services.PasajeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pasajeros")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }


    @GetMapping
    public ResponseEntity<List<PasajeroDTO>> obtenerPasajero() {
        return ResponseEntity.ok(pasajeroService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<PasajeroDTO> obtenerPasajeroPorId(@PathVariable("id") Long id) {
        return pasajeroService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseThrow(()->new PasajeroNotFoundException("No se puede encontrar al pasajero con el ID "+id));
    }

    @PostMapping
    public ResponseEntity<PasajeroDTO> crearPasajero(@RequestBody PasajeroDTO pasajero) {
        return createPasajero(pasajero);
    }


    @PutMapping("/id")
    public ResponseEntity<PasajeroDTO> actualizarPasajero(@PathVariable Long id, @RequestBody PasajeroDTO pasajero) {
        Optional<PasajeroDTO> pasajeroUpdate = pasajeroService.updatePasajero(id, pasajero);
        return pasajeroUpdate.map(p -> ResponseEntity.ok(p)).orElseGet(() -> {
            return createPasajero(pasajero);
        });
    }

    private ResponseEntity<PasajeroDTO> createPasajero(PasajeroDTO pasajero) {
        PasajeroDTO newPasajero = pasajeroService.savePasajero(pasajero);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPasajero.id()).toUri();
        return ResponseEntity.created(location).body(newPasajero);
    }

    @DeleteMapping("/id")
    public ResponseEntity<PasajeroDTO> deletePasajero(@PathVariable Long id) {
        return pasajeroService.findById(id).map(a-> {
            pasajeroService.deletePasajero(id);
            return ResponseEntity.ok().body(a);
        }).orElse(ResponseEntity.notFound().build());
    }
}
