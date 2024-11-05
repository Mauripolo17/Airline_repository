package com.airline.airline.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private int numeroDocumento;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private int telefono;

    @Column(nullable = false) @Temporal(TemporalType.TIMESTAMP) @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaDeNacimiento;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(targetEntity = Reserva.class ,mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Reserva> reservas;

}
