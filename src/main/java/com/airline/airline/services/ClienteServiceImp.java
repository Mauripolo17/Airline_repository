package com.airline.airline.services;

import com.airline.airline.entities.Cliente;
import com.airline.airline.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImp implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Cliente> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Cliente> findByNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return null;
    }

    @Override
    public void deleteCliente(Long id) {

    }

    @Override
    public Optional<Cliente> updateCliente(Long id, Cliente cliente) {
        return Optional.empty();
    }

    @Override
    public List<Cliente> findAllCliente() {
        return List.of();
    }
}
