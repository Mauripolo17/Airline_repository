package com.airline.airline.security.services;

import com.airline.airline.dto.ReservaDTO;
import com.airline.airline.dto.ReservaMapper;
import com.airline.airline.entities.Reserva;
import com.airline.airline.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImp implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    private final ClienteService clienteService;

    public ReservaServiceImp(ReservaRepository reservaRepository, ReservaMapper reservaMapper, ClienteService clienteService) {

        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
        this.clienteService = clienteService;
    }

    @Override
    public Optional<ReservaDTO> findById(Long id) {
        return reservaRepository.findById(id).map(reservaMapper::toDTO);
    }

    @Override
    public Reserva findReservaById(Long id) {
        return reservaRepository.findById(id).orElse(null)  ;
    }

    @Override
    public List<ReservaDTO> findAll() {
        return reservaRepository.findAll().stream().map(dto -> reservaMapper.toDTOWithoutId(dto)).collect(Collectors.toList());
    }



    public Optional<ReservaDTO> updateReserva(Long id, ReservaDTO reserva) {
        return reservaRepository.findById(id).map(reservaInBD->{
            reservaInBD.setCliente(clienteService.findClienteById(reserva.cliente()).orElse(null));
            reservaInBD.setFechaReserva(reserva.fechaReserva());
            return reservaRepository.save(reservaInBD);
        }).map(reservaMapper::toDTO);
    }


    @Override
    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public Optional<ReservaDTO> findByFlightId(Long id) {
        return reservaRepository.findByVuelos_Id(id).map(reservaMapper::toDTOWithoutId);
    }

    @Override
    public ReservaDTO saveReserva(ReservaDTO reserva) {
        Reserva reservaEntity = reservaMapper.toEntity(reserva, clienteService);
        return reservaMapper.toDTO(reservaRepository.save(reservaEntity));
    }



}
