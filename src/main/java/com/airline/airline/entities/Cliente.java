package com.airline.airline.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column
    @JsonIgnore
    private String password;

    private String email;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = true)
    private String apellido;

    @Column(nullable = true)
    private Long numeroDocumento;

    @Column(nullable = true)
    private String direccion;

    @Column(nullable = true)
    private Long telefono;

    @Column(nullable = true) @Temporal(TemporalType.TIMESTAMP) @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaDeNacimiento;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @JsonIgnore
    @OneToMany(targetEntity = Reserva.class ,mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Reserva> reservas;

    public void addRole(Role role) {
        this.roles.add(role);
        role.getClientes().add(this); // Si existe una relación inversa
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
        role.getClientes().remove(this); // Si existe una relación inversa
    }
}
