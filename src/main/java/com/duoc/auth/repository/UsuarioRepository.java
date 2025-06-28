package com.duoc.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.auth.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
     Optional<Usuario> findByEmailAndPassword(String email, String password);
}
