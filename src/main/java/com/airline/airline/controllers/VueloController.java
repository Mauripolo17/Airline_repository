package com.airline.airline.controllers;

import com.airline.airline.dto.VueloDTO;
import com.airline.airline.entities.Vuelo;
import com.airline.airline.exceptions.VueloNotFoundException;
import com.airline.airline.security.services.VueloService;
import org.springframework.cache.Cache;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vuelos")
@PreAuthorize("hasRole('user')")
@CrossOrigin("http://localhost:5173/")
public class VueloController {
    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }
    @PreAuthorize("hasRole('user')")
    @GetMapping
    public ResponseEntity<List<VueloDTO>> obtenerVuelo() {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloDTO> obtenerVueloPorId(@PathVariable("id") Long id) {
        return vueloService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseThrow(()->new VueloNotFoundException("No se encontró el vuelo con el ID "+id));
    }

    @PostMapping
    @PreAuthorize("hasRole('user')")
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
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newVuelo.id()).toUri();
        return ResponseEntity.created(location).body(newVuelo);
    }

    @DeleteMapping("/id")
    public ResponseEntity<VueloDTO> deleteVuelo(@PathVariable Long id) {
        return vueloService.findById(id).map(a-> {
            vueloService.deleteVuelo(id);
            return ResponseEntity.ok().body(a);
        }).orElseThrow(()->new VueloNotFoundException("No se encontró el vuelo con el ID "+id));
    }
}
