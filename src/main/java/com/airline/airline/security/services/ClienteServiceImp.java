package com.airline.airline.security.services;

import com.airline.airline.dto.ClienteDTO;
import com.airline.airline.dto.ClienteMapper;
import com.airline.airline.entities.Cliente;
import com.airline.airline.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImp implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImp(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(dto -> clienteMapper.toDTOWithoutId(dto)).collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDTO> findById(Long id) {
        return clienteRepository.findById(id).map(clienteMapper::toDTO);
    }

    @Override
    public Optional<ClienteDTO> findByEmail(String email) {
        return clienteRepository.findByEmail(email).map(clienteMapper::toDTOWithoutId);
    }

    @Override
    public Optional<ClienteDTO> findByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre).map(clienteMapper::toDTOWithoutId);
    }

    @Override
    public ClienteDTO saveCliente(ClienteDTO cliente) {
        Cliente clienteEntity = clienteMapper.toEntity(cliente);
        return clienteMapper.toDTO(clienteRepository.save(clienteEntity));
    }


    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<ClienteDTO> updateCliente(Long id, ClienteDTO cliente) {
        return clienteRepository.findById(id).
                map(oldCliente-> {
                    oldCliente.setNombre(cliente.nombre());
                    oldCliente.setApellido(cliente.apellido());
                    oldCliente.setDireccion(cliente.direccion());
                    oldCliente.setTelefono(cliente.telefono());
                    oldCliente.setEmail(cliente.email());
                    oldCliente.setFechaDeNacimiento(cliente.fechaDeNacimiento());
                    return clienteRepository.save(oldCliente);
                }).map(clienteMapper::toDTO);
    }

}
