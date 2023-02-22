package com.argprog.backend.repositorios;

import com.argprog.backend.entidades.Experiencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciasRepo extends JpaRepository<Experiencias, Integer>{
        
}
