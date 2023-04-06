package com.argprog.myportfolio.repositorios;

import com.argprog.myportfolio.Entidades.Experiencias;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciasRepo extends JpaRepository<Experiencias, Integer> {
        
}
