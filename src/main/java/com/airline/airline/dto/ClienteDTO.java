package com.airline.airline.dto;

import java.util.Date;

public record ClienteDTO(Long id, String nombre, String apellido, String direccion, Integer telefono, String correoElectronico, Date fechaDeNacimiento) {
}
