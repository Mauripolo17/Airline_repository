package com.airline.airline.controllers;

import com.airline.airline.entities.Aerolinea;
import com.airline.airline.entities.Cliente;
import com.airline.airline.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerCliente() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable("id") Long id) {
        return clienteService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return createCliente(cliente);
    }


    @PutMapping("/id")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteUpdate = clienteService.updateCliente(id, cliente);
        return clienteUpdate.map(c -> ResponseEntity.ok(c)).orElseGet(() -> {
            return createCliente(cliente);
        });
    }

    private ResponseEntity<Cliente> createCliente(Cliente cliente) {
        Cliente newCliente = clienteService.saveCliente(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCliente.getId()).toUri();
        return ResponseEntity.created(location).body(newCliente);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id) {
        return clienteService.findById(id).map(a-> {
            clienteService.deleteCliente(id);
            return ResponseEntity.ok().body(a);
        }).orElse(ResponseEntity.notFound().build());
    }
}
