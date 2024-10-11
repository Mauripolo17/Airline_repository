package com.airline.airline.controllers;

import com.airline.airline.entities.Pasajero;
import com.airline.airline.services.PasajeroService;
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
    public ResponseEntity<List<Pasajero>> obtenerPasajero() {
        return ResponseEntity.ok(pasajeroService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Pasajero> obtenerPasajeroPorId(@PathVariable("id") Long id) {
        return pasajeroService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pasajero> crearPasajero(@RequestBody Pasajero pasajero) {
        return createPasajero(pasajero);
    }


    @PutMapping("/id")
    public ResponseEntity<Pasajero> actualizarPasajero(@PathVariable Long id, @RequestBody Pasajero pasajero) {
        Optional<Pasajero> pasajeroUpdate = pasajeroService.updatePasajero(id, pasajero);
        return pasajeroUpdate.map(p -> ResponseEntity.ok(p)).orElseGet(() -> {
            return createPasajero(pasajero);
        });
    }

    private ResponseEntity<Pasajero> createPasajero(Pasajero pasajero) {
        Pasajero newPasajero = pasajeroService.savePasajero(pasajero);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPasajero.getId()).toUri();
        return ResponseEntity.created(location).body(newPasajero);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Pasajero> deletePasajero(@PathVariable Long id) {
        return pasajeroService.findById(id).map(a-> {
            pasajeroService.deletePasajero(id);
            return ResponseEntity.ok().body(a);
        }).orElse(ResponseEntity.notFound().build());
    }
}
