package com.argprog.myportfolio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprog.myportfolio.Entidades.Estudios;
import com.argprog.myportfolio.repositorios.EstudiosRepo;

@Service
public class EstudiosServ {
    
    @Autowired
    private EstudiosRepo repo;

    public List<Estudios> getEstudios() {
        return repo.findAll();
    }

    public void save(Estudios est) {
        repo.save(est);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
