package com.argprog.myportfolio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprog.myportfolio.Entidades.Habilidades;
import com.argprog.myportfolio.repositorios.HabilidadesRepo;

@Service
public class HabilidadesServ {

    @Autowired
    private HabilidadesRepo repo;
    
    public List<Habilidades> getHabilidades() {
        return repo.findAll();
    }
    
    public void save(Habilidades habilidad) {
        repo.save(habilidad);
    }
    
    public void delete(int id) {
        repo.deleteById(id);
    }
}
