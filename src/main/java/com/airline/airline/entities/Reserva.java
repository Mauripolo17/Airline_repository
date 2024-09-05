package com.airline.airline.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservas")
@Entity
public class Reserva {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false) @Temporal(TemporalType.TIMESTAMP) @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaReserva;

    @ManyToOne(targetEntity = Cliente.class)
    private Cliente cliente;

    @OneToMany(targetEntity = Pasajero.class, mappedBy = "reserva", fetch = FetchType.LAZY)
    private Set<Pasajero> pasajeros;

}
