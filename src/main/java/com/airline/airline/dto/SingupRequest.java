package com.airline.airline.dto;

import java.util.Date;
import java.util.Set;

public record SingupRequest(Long id,
                            String username,
                            String email,
                            String password,
                            String nombre,
                            String apellido,
                            Long numeroDocumento,
                            String direccion,
                            Long telefono,
                            Date fechaDeNacimiento,
                            Set<String> roles) {
}
