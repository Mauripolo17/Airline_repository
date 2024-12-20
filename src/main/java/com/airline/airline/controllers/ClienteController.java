package com.airline.airline.controllers;

import com.airline.airline.dto.ClienteDTO;
import com.airline.airline.entities.Cliente;
import com.airline.airline.exceptions.ClienteNotFoundException;
import com.airline.airline.exceptions.EmailDuplicatedException;
import com.airline.airline.exceptions.ExistingUsernameException;
import com.airline.airline.security.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:5173/")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<List<ClienteDTO>> obtenerCliente() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable("id") Long id) {
        return clienteService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseThrow(()->new ClienteNotFoundException("No se pudo encontrar al cliente con el ID "+id));
    }

    @GetMapping("/username/{username}")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<ClienteDTO> obtenerClientePorUsername(@PathVariable("username") String username) {
        return clienteService.findByUsername(username)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseThrow(()->new ClienteNotFoundException("No se pudo encontrar al cliente con el username "+ username));
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO cliente) throws ExistingUsernameException, EmailDuplicatedException {
        if (clienteService.findByNombre(cliente.nombre()).isPresent()) {
            throw new ExistingUsernameException("El numero de usuario "+cliente.username()+"ya existe");
        }else if(clienteService.findByEmail(cliente.email()).isPresent()){
            throw  new EmailDuplicatedException("Ya existe un usuario registrado con el email "+cliente.email());
        }
        return createCliente(cliente);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente) {
        Optional<ClienteDTO> clienteUpdate = clienteService.updateCliente(id, cliente);
        return clienteUpdate.map(c -> ResponseEntity.ok(c)).orElseGet(() -> {
            return createCliente(cliente);
        });
    }

    private ResponseEntity<ClienteDTO> createCliente(ClienteDTO cliente) {
        ClienteDTO newCliente = clienteService.saveCliente(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCliente.id()).toUri();
        return ResponseEntity.created(location).body(newCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDTO> deleteCliente(@PathVariable Long id) {
        return clienteService.findById(id).map(a-> {
            clienteService.deleteCliente(id);
            return ResponseEntity.ok().body(a);
        }).orElseThrow(()->new ClienteNotFoundException("No se encontró el cliente "+id));
    }
}
