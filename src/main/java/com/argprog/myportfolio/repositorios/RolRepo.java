package com.argprog.myportfolio.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argprog.myportfolio.Entidades.Rol;
import com.argprog.myportfolio.Enum.Roles;

import org.springframework.stereotype.Repository;

@Repository
public interface RolRepo extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRol(Roles rol);
    
}
