package com.argprog.myportfolio.servicios;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprog.myportfolio.Entidades.Usuario;
import com.argprog.myportfolio.repositorios.UsuarioRepo;

import jakarta.transaction.Transactional;

@Service @Transactional
public class UsuarioServ {
    
    @Autowired
    private UsuarioRepo repo;

    public Optional<Usuario> getUsuario(String nombre) {
        return repo.findByNombre(nombre);
    }

    public boolean existUsuario(String nombre) {
        return repo.existsByNombre(nombre);
    }

    public void save(Usuario user) {
        repo.save(user);
    }
}
