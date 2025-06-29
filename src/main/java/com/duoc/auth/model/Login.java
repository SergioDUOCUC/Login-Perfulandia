package com.duoc.auth.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Login", description = "Modelo para la autenticación de usuarios mediante email y contraseña")
public class Login {

    @Schema(description = "Correo electrónico del usuario", example = "usuario@correo.com", required = true)
    private String email;

    @Schema(description = "Contraseña del usuario", example = "password123", required = true)
    private String password;
}
