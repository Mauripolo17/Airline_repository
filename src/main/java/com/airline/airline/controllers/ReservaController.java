package com.airline.airline.controllers;

import com.airline.airline.dto.ReservaDTO;
import com.airline.airline.entities.Reserva;
import com.airline.airline.exceptions.ReservaNotFoundException;
import com.airline.airline.security.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }


    @GetMapping
    public ResponseEntity<List<ReservaDTO>> obtenerReserva() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<ReservaDTO> obtenerReservaPorId(@PathVariable("id") Long id) {
        return reservaService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseThrow(()->new ReservaNotFoundException("No se puede encontrar la reserva con el ID "+id));
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> crearReserva(@RequestBody ReservaDTO reserva) {
        return createReserva(reserva);
    }


    @PutMapping("/id")
    public ResponseEntity<ReservaDTO> actualizarReserva(@PathVariable Long id, @RequestBody ReservaDTO reserva) {
        Optional<ReservaDTO> reservaUpdate = reservaService.updateReserva(id, reserva);
        return reservaUpdate.map(p -> ResponseEntity.ok(p)).orElseGet(() -> {
            return createReserva(reserva);
        });
    }

    private ResponseEntity<ReservaDTO> createReserva(ReservaDTO reserva) {
        ReservaDTO newReserva = reservaService.saveReserva(reserva);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newReserva.id()).toUri();
        return ResponseEntity.created(location).body(newReserva);
    }

    @DeleteMapping("/id")
    public ResponseEntity<ReservaDTO> deleteReserva(@PathVariable Long id) {
        return reservaService.findById(id).map(a-> {
            reservaService.deleteReserva(id);
            return ResponseEntity.ok().body(a);
        }).orElseThrow(()->new ReservaNotFoundException("No se encontró la reserva con el ID "+id));
    }
}
