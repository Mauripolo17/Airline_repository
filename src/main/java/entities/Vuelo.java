package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Clientes")
@Entity
public class Vuelo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false) @Temporal(TemporalType.TIMESTAMP) @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaDeSalida;

    @Column(nullable = false)  @Temporal(TemporalType.TIME)  @DateTimeFormat(iso = ISO.TIME)
    private Date horaDeSalida;

    @Column(nullable = false) @DateTimeFormat(pattern = "HH:mm")
    private LocalTime duracion;

    @Column(nullable = false)
    private int capacidad;


}
