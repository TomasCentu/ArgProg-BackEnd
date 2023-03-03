package com.argprog.backend.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprog.backend.entidades.Habilidades;
import com.argprog.backend.repositorios.HabilidadesRepo;

@Service
public class HabilidadesServ {

    @Autowired
    private HabilidadesRepo repo;
    
    public List<Habilidades> getHabilidades() {
        return repo.findAll();
    }
    
    public Habilidades getHabilidad(int id) {
        return repo.findById(id).orElse(null);
    }
    
    public void save(Habilidades habilidad) {
        repo.save(habilidad);
    }
    
    public void delete(int id) {
        repo.deleteById(id);
    }
    
    public void edit(Habilidades habilidad) {
        Habilidades OldHabilidades = repo.findById(habilidad.getId()).orElse(null);
        OldHabilidades.setPorcentaje(habilidad.getPorcentaje());
            
        repo.save(OldHabilidades);
    }
}
