package com.airline.airline.controllers;

import com.airline.airline.entities.Aerolinea;
import com.airline.airline.services.AerolineaService;
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
    public ResponseEntity<List<Aerolinea>> obtenerAerolinea() {
        return ResponseEntity.ok(aerolineaService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Aerolinea> obtenerAerolineaPorId(@PathVariable("id") Long id) {
        return aerolineaService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aerolinea> crearAerolinea(@RequestBody Aerolinea aerolinea) {
        return createAerolinea(aerolinea);
    }


    @PutMapping("/id")
    public ResponseEntity<Aerolinea> actualizarAerolinea(@PathVariable Long id, @RequestBody Aerolinea aerolinea) {
        Optional<Aerolinea> aerolineaUpdate = aerolineaService.update(id, aerolinea);
        return aerolineaUpdate.map(c -> ResponseEntity.ok(c)).orElseGet(() -> {
            return createAerolinea(aerolinea);
        });
    }

    private ResponseEntity<Aerolinea> createAerolinea(Aerolinea aerolinea) {
        Aerolinea newAerolinea = aerolineaService.save(aerolinea);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAerolinea.getId()).toUri();
        return ResponseEntity.created(location).body(newAerolinea);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Aerolinea> deleteAerolinea(@PathVariable Long id) {
           return aerolineaService.findById(id).map(a-> {
               aerolineaService.delete(id);
               return ResponseEntity.ok().body(a);
           }).orElse(ResponseEntity.notFound().build());
    }


}

