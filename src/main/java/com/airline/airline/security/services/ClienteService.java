package com.airline.airline.security.services;

import com.airline.airline.dto.ClienteDTO;
import com.airline.airline.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<ClienteDTO> findAll();

    Optional<ClienteDTO> findById(Long id);

    Optional<ClienteDTO> findByEmail(String email);

    Optional<ClienteDTO>  findByNombre(String nombre);

    ClienteDTO saveCliente(ClienteDTO cliente);

    void deleteCliente(Long id);

    Optional<ClienteDTO> updateCliente(Long id, ClienteDTO cliente);
}
