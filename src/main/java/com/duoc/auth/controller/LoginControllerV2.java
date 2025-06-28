/*package com.duoc.auth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.auth.assembler.LoginModelAssembler;
import com.duoc.auth.model.Login;
import com.duoc.auth.model.Usuario;
import com.duoc.auth.services.UsuarioServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class LoginControllerV2 {

     @Autowired
    private UsuarioServices usuarioservices;

    @Autowired
    private LoginModelAssembler assembler;

    @PostMapping("/login1")
    public ResponseEntity<?> login(@RequestBody Login login){
        Optional<Usuario> usuario = usuarioservices.autenticar(login.getEmail(), login.getPassword());

        if (usuario.isPresent()) {
            EntityModel<Usuario> model = assembler.toModel(usuario.get());
            return ResponseEntity.ok(model);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario incorrecto!");
        }
    }

}
    /* */
