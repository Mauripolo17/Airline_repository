package com.airline.airline.controllers;

import com.airline.airline.entities.Vuelo;
import com.airline.airline.services.VueloService;
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
    public ResponseEntity<List<Vuelo>> obtenerVuelo() {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Vuelo> obtenerVueloPorId(@PathVariable("id") Long id) {
        return vueloService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vuelo> crearVuelo(@RequestBody Vuelo vuelo) {
        return createVuelo(vuelo);
    }


    @PutMapping("/id")
    public ResponseEntity<Vuelo> actualizarVuelo(@PathVariable Long id, @RequestBody Vuelo vuelo) {
        Optional<Vuelo> vueloUpdate = vueloService.updateVuelo(id, vuelo);
        return vueloUpdate.map(p -> ResponseEntity.ok(p)).orElseGet(() -> {
            return createVuelo(vuelo);
        });
    }

    private ResponseEntity<Vuelo> createVuelo(Vuelo vuelo) {
        Vuelo newVuelo = vueloService.saveVuelo(vuelo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newVuelo.getId()).toUri();
        return ResponseEntity.created(location).body(newVuelo);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Vuelo> deleteVuelo(@PathVariable Long id) {
        return vueloService.findById(id).map(a-> {
            vueloService.deleteVuelo(id);
            return ResponseEntity.ok().body(a);
        }).orElse(ResponseEntity.notFound().build());
    }
}
