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
        return clienteRepository.findById(id);
    }

    @Override
    public Optional<Cliente> findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public Optional<Cliente> findByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }


    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> updateCliente(Long id, Cliente cliente) {
        return clienteRepository.findById(id).
                map(oldCliente-> {
                    oldCliente.setNombre(cliente.getNombre());
                    oldCliente.setApellido(cliente.getApellido());
                    oldCliente.setDireccion(cliente.getDireccion());
                    oldCliente.setTelefono(cliente.getTelefono());
                    oldCliente.setCorreoElectronico(cliente.getCorreoElectronico());
                    oldCliente.setFechaDeNacimiento(cliente.getFechaDeNacimiento());

                    return clienteRepository.save(oldCliente);
                });
    }

}
