package com.argprog.backend.repositorios;

import com.argprog.backend.entidades.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepo extends JpaRepository<Estudios, Integer>{

}
