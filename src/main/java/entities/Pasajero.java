package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pasajeros")
@Entity
public class Pasajero {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



}
