package com.argprog.myportfolio.repositorios;

import com.argprog.myportfolio.Entidades.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepo extends JpaRepository<Estudios, Integer> {

}
