package com.duoc.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.auth.model.Usuario;
import com.duoc.auth.repository.UsuarioRepository;

import jakarta.transaction.Transactional;


@Transactional
@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuariorepository;

    public boolean validarCredenciales(String email, String password){
        return usuariorepository.findByEmailAndPassword(email, password).isPresent();

    }

    public Optional<Usuario> autenticar(String email, String password) {
        return usuariorepository.findByEmailAndPassword(email, password)
            .map(usuario -> new Usuario(
                usuario.getId_cliente(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getDireccion(),
                usuario.getEstado(), password
            ));
    }

    

}
