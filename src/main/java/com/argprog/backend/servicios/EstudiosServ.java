package com.argprog.backend.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprog.backend.entidades.Estudios;
import com.argprog.backend.repositorios.EstudiosRepo;

@Service
public class EstudiosServ {
    
    @Autowired
    private EstudiosRepo repo;

    public List<Estudios> getEstudios() {
        return repo.findAll();
    }

    public Estudios getEstudio(int id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Estudios est) {
        repo.save(est);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void edit(Estudios est) {
        Estudios OldEst = repo.findById(est.getId()).orElse(null);

        OldEst.setNombre(est.getNombre());
        OldEst.setFoto(est.getFoto());
        OldEst.setDescripcion(est.getDescripcion());

        repo.save(OldEst);
    }
}
