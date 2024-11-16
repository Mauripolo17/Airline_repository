package com.airline.airline.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aerolineas")
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Long codigoAerolinea;

    @Column(nullable = false)
    private String paisOrigen;

    @OneToMany(targetEntity = Vuelo.class, mappedBy = "aerolinea", fetch = FetchType.LAZY)
    private Set<Vuelo> vuelos;

}
