package com.airline.airline.controllers;

import com.airline.airline.entities.Aeropuerto;
import com.airline.airline.services.AeropuertoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aeropuerto")
public class AeropuertoController {
    private final AeropuertoService aeropuertoService;


    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }

    @GetMapping
    public ResponseEntity<List<Aeropuerto>> obtenerAerolinea() {
        return ResponseEntity.ok(aeropuertoService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Aeropuerto> obtenerAeropuertoPorId(@PathVariable("id") Long id) {
        return aeropuertoService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aeropuerto> crearAeropuerto(@RequestBody Aeropuerto aeropuerto) {
        return createAeropuerto(aeropuerto);
    }


    @PutMapping("/id")
    public ResponseEntity<Aeropuerto> actualizarAeropuerto(@PathVariable Long id, @RequestBody Aeropuerto aeropuerto) {
        Optional<Aeropuerto> aeropuertoUpdate = aeropuertoService.update(id, aeropuerto);
        return aeropuertoUpdate.map(a -> ResponseEntity.ok(a)).orElseGet(() -> {
            return createAeropuerto(aeropuerto);
        });
    }

    private ResponseEntity<Aeropuerto> createAeropuerto(Aeropuerto aeropuerto) {
        Aeropuerto newAeropuerto = aeropuertoService.save(aeropuerto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAeropuerto.getId()).toUri();
        return ResponseEntity.created(location).body(newAeropuerto);
    }

    @DeleteMapping
    public ResponseEntity<Aeropuerto> deleteAeropuerto(@PathVariable Long id) {
        return aeropuertoService.findById(id).map(a-> {
            aeropuertoService.delete(id);
            return ResponseEntity.ok().body(a);
        }).orElse(ResponseEntity.notFound().build());
    }

}

