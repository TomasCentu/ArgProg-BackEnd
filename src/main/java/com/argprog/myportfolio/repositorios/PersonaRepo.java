package com.argprog.myportfolio.repositorios;

import com.argprog.myportfolio.Entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Integer> {

}
