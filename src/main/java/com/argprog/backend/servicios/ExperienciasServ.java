package com.argprog.backend.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprog.backend.entidades.Experiencias;
import com.argprog.backend.repositorios.ExperienciasRepo;

@Service
public class ExperienciasServ {
    
    @Autowired
    private ExperienciasRepo repo;

    public List<Experiencias> getExperiencias() {
        return repo.findAll();
    } 

    public Experiencias getExperiencia(int id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Experiencias exp) {
        repo.save(exp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void edit(Experiencias exp) {
        Experiencias expOld = repo.findById(exp.getId()).orElse(null);

        expOld.setNombre(exp.getNombre());
        expOld.setFoto(exp.getFoto());
        expOld.setDescripcion(exp.getDescripcion());
        
        repo.save(expOld);
    }
}
