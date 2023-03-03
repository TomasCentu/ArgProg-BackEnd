package com.argprog.backend.repositorios;

import com.argprog.backend.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepo extends JpaRepository<Persona, Integer>{

}
