package com.argprog.myportfolio.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.argprog.myportfolio.Entidades.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
    
}
