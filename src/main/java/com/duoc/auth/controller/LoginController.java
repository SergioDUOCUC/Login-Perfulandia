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


@RestController
@RequestMapping("/api/v1/auth")

public class LoginController {

    @Autowired
    private UsuarioServices usuarioservices;
    
   @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Login login){
    Optional<Usuario> usuario = usuarioservices.autenticar(login.getEmail(), login.getPassword());

    if (usuario.isPresent()) {
        return ResponseEntity.ok(usuario.get());
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario incorrecto!");
    }
}




}
