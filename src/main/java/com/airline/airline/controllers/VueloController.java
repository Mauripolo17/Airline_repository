package com.airline.airline.controllers;

import com.airline.airline.dto.VueloDTO;
import com.airline.airline.entities.Vuelo;
import com.airline.airline.security.services.VueloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {
    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }


    @GetMapping
    public ResponseEntity<List<VueloDTO>> obtenerVuelo() {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<VueloDTO> obtenerVueloPorId(@PathVariable("id") Long id) {
        return vueloService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VueloDTO> crearVuelo(@RequestBody VueloDTO vuelo) {
        return createVuelo(vuelo);
    }


    @PutMapping("/id")
    public ResponseEntity<VueloDTO> actualizarVuelo(@PathVariable Long id, @RequestBody VueloDTO vuelo) {
        Optional<VueloDTO> vueloUpdate = vueloService.updateVuelo(id, vuelo);
        return vueloUpdate.map(p -> ResponseEntity.ok(p)).orElseGet(() -> {
            return createVuelo(vuelo);
        });
    }

    private ResponseEntity<VueloDTO> createVuelo(VueloDTO vuelo) {
        VueloDTO newVuelo = vueloService.saveVuelo(vuelo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newVuelo.getId()).toUri();
        return ResponseEntity.created(location).body(newVuelo);
    }

    @DeleteMapping("/id")
    public ResponseEntity<VueloDTO> deleteVuelo(@PathVariable Long id) {
        return vueloService.findById(id).map(a-> {
            vueloService.deleteVuelo(id);
            return ResponseEntity.ok().body(a);
        }).orElse(ResponseEntity.notFound().build());
    }
}
