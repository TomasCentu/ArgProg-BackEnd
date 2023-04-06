package com.argprog.myportfolio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprog.myportfolio.Entidades.Proyectos;
import com.argprog.myportfolio.repositorios.ProyectosRepo;

@Service
public class ProyectosServ {

    @Autowired
    private ProyectosRepo repo;

    public List<Proyectos> getProyectos() {
        return repo.findAll();
    }

    public void save(Proyectos pro) {
        repo.save(pro);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
