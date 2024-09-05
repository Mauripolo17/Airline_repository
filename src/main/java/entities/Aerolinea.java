package entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "aerolineas")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int codigoAerolinea;

    @Column(nullable = false)
    private String paisOrigen;

}
