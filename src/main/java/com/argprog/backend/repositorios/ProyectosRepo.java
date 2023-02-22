package com.argprog.backend.repositorios;

import com.argprog.backend.entidades.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepo extends JpaRepository<Proyectos, Integer>{

}
