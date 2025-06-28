package com.duoc.auth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.duoc.auth.services.UsuarioServices;

@SpringBootTest
public class LoginTest {

    @Autowired
    UsuarioServices usuarioservice;

     @Test
    public void testValidacion() {
        
        String email = "duocuc@gmail.com";
        String password = "123456789";

        boolean resultado = usuarioservice.validarCredenciales(email, password);

        Assertions.assertTrue(resultado, "El usuario debe ser válido");
    }

}
