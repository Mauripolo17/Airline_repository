package com.airline.airline.dto;

import java.util.Date;

public record ClienteDTO(Long id, String username, String password, String nombre, String apellido,
                         Integer numeroDocumento, String direccion, Integer telefono, String email,
                         Date fechaDeNacimiento) {
}
