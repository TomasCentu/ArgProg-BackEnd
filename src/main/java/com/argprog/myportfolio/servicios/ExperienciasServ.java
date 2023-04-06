package com.argprog.myportfolio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprog.myportfolio.Entidades.Experiencias;
import com.argprog.myportfolio.repositorios.ExperienciasRepo;

@Service
public class ExperienciasServ {
    
    @Autowired
    private ExperienciasRepo repo;

    public List<Experiencias> getExperiencias() {
        return repo.findAll();
    }

    public void save(Experiencias exp) {
        repo.save(exp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
