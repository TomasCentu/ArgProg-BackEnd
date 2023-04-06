package com.argprog.myportfolio.repositorios;

import com.argprog.myportfolio.Entidades.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepo extends JpaRepository<Habilidades, Integer> {

}
