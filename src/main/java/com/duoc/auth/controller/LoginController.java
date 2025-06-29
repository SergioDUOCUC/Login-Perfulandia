package com.duoc.auth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.auth.model.Login;
import com.duoc.auth.model.Usuario;
import com.duoc.auth.services.UsuarioServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    @Autowired
    private UsuarioServices usuarioservices;

    @Operation(summary = "Autenticación de usuario", description = "Permite a un usuario autenticarse usando email y contraseña")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario autenticado correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))),
        @ApiResponse(responseCode = "401", description = "Credenciales inválidas o usuario no autorizado",
            content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        Optional<Usuario> usuario = usuarioservices.autenticar(login.getEmail(), login.getPassword());

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario incorrecto!");
        }
    }
}
