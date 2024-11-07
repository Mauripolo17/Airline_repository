package com.airline.airline.controllers;

import com.airline.airline.dto.AeropuertoDTO;
import com.airline.airline.entities.Aeropuerto;
import com.airline.airline.exceptions.AeropuertoNotFoundException;
import com.airline.airline.security.services.AeropuertoService;
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
    public ResponseEntity<List<AeropuertoDTO>> obtenerAerolinea() {
        return ResponseEntity.ok(aeropuertoService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<AeropuertoDTO> obtenerAeropuertoPorId(@PathVariable("id") Long id) {
        return aeropuertoService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseThrow(()->new AeropuertoNotFoundException("No se puede encontrar el aeropuerto con el ID" +id));
    }

    @PostMapping
    public ResponseEntity<AeropuertoDTO> crearAeropuerto(@RequestBody AeropuertoDTO aeropuerto) {
        return createAeropuerto(aeropuerto);
    }


    @PutMapping("/id")
    public ResponseEntity<AeropuertoDTO> actualizarAeropuerto(@PathVariable Long id, @RequestBody AeropuertoDTO aeropuerto) {
        Optional<AeropuertoDTO> aeropuertoUpdate = aeropuertoService.update(id, aeropuerto);
        return aeropuertoUpdate.map(a -> ResponseEntity.ok(a)).orElseGet(() -> {
            return createAeropuerto(aeropuerto);
        });
    }

    private ResponseEntity<AeropuertoDTO> createAeropuerto(AeropuertoDTO aeropuerto) {
        AeropuertoDTO newAeropuerto = aeropuertoService.save(aeropuerto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAeropuerto.id()).toUri();
        return ResponseEntity.created(location).body(newAeropuerto);
    }

    @DeleteMapping
    public ResponseEntity<AeropuertoDTO> deleteAeropuerto(@PathVariable Long id) {
        return aeropuertoService.findById(id).map(a-> {
            aeropuertoService.delete(id);
            return ResponseEntity.ok().body(a);
        }).orElse(ResponseEntity.notFound().build());
    }

}

