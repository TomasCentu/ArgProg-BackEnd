package com.argprog.myportfolio.repositorios;

import com.argprog.myportfolio.Entidades.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepo extends JpaRepository<Proyectos, Integer> {

}
