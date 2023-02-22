package com.argprog.backend.repositorios;

import com.argprog.backend.entidades.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepo extends JpaRepository<Habilidades, Integer>{

}
