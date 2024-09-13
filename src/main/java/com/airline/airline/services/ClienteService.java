package com.airline.airline.services;

import com.airline.airline.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Optional<Cliente> findById(Long id);

    Optional<Cliente> findByEmail(String email);

    Optional<Cliente>  findByNombre(String nombre);

    void saveCliente(Cliente cliente);

    void deleteCliente(Long id);

    Optional<Cliente> updateCliente(Long id, Cliente cliente);
}
