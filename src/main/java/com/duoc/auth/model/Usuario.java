package com.duoc.auth.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Usuario", description = "Representa un usuario cliente en el sistema")
public class Usuario {

    @Id
    @Column(name = "id_cliente")
    @Schema(description = "Identificador único del cliente", example = "CL123", required = true)
    private String id_cliente;

    @Column(nullable = false)
    @Schema(description = "Nombre del usuario", example = "Juan", required = true)
    private String nombre;

    @Column(nullable = false)
    @Schema(description = "Apellido del usuario", example = "Pérez", required = true)
    private String apellido;

    @Column(nullable = false)
    @Schema(description = "Correo electrónico del usuario", example = "juan.perez@email.com", required = true)
    private String email;

    @Column(nullable = false)
    @Schema(description = "Número telefónico del usuario", example = "987654321", required = true)
    private int telefono;

    @Column(nullable = false)
    @Schema(description = "Dirección del usuario", example = "Calle Falsa 123", required = true)
    private String direccion;

    @Column(nullable = false)
    @Schema(description = "Contraseña del usuario (encriptada)", example = "********", required = true)
    private String password;

    @Column(nullable = false)
    @Schema(description = "Estado del usuario (ACTIVADO/DESACTIVADO)", example = "ACTIVADO", required = true)
    private String estado;
}
