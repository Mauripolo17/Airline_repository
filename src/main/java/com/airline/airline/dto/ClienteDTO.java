package com.airline.airline.dto;

import java.util.Date;

public record ClienteDTO(Long id,
                         String username,
                         String email,
                         String password,
                         String nombre,
                         String apellido,
                         Long numeroDocumento,
                         String direccion,
                         Long telefono,
                         Date fechaDeNacimiento) {
}
