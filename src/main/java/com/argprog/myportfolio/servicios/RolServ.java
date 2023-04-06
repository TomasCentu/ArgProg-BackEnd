package com.argprog.myportfolio.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprog.myportfolio.Entidades.Rol;
import com.argprog.myportfolio.Enum.Roles;
import com.argprog.myportfolio.repositorios.RolRepo;

import jakarta.transaction.Transactional;

@Service @Transactional
public class RolServ {

    @Autowired
    private RolRepo repo;

    public Optional<Rol> getRol(Roles roles) {
        return repo.findByRol(roles);
    }

    public void save(Rol rol) {
        repo.save(rol);
    }
}
