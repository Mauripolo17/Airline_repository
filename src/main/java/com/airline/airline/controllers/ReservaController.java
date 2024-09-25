package com.airline.airline.controllers;

import com.airline.airline.entities.Pasajero;
import com.airline.airline.entities.Reserva;
import com.airline.airline.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }


    @GetMapping
    public ResponseEntity<List<Reserva>> obtenerReserva() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable("id") Long id) {
        return reservaService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        return createReserva(reserva);
    }


    @PutMapping("/id")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        Optional<Reserva> reservaUpdate = reservaService.updateReserva(id, reserva);
        return reservaUpdate.map(p -> ResponseEntity.ok(p)).orElseGet(() -> {
            return createReserva(reserva);
        });
    }

    private ResponseEntity<Reserva> createReserva(Reserva reserva) {
        Reserva newReserva = reservaService.saveReserva(reserva);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newReserva.getId()).toUri();
        return ResponseEntity.created(location).body(newReserva);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Reserva> deleteReserva(@PathVariable Long id) {
        return reservaService.findById(id).map(a-> {
            reservaService.deleteReserva(id);
            return ResponseEntity.ok().body(a);
        }).orElse(ResponseEntity.notFound().build());
    }
}
