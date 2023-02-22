package com.argprog.backend.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprog.backend.entidades.Proyectos;
import com.argprog.backend.repositorios.ProyectosRepo;

@Service
public class ProyectosServ {

    @Autowired
    private ProyectosRepo repo;

    public List<Proyectos> getProyectos() {
        return repo.findAll();
    }

    public Proyectos getProyecto(int id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Proyectos pro) {
        repo.save(pro);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void edit(Proyectos pro) {
        Proyectos OldPro = repo.findById(pro.getId()).orElse(null);

        OldPro.setNombre(pro.getNombre());
        OldPro.setFoto(pro.getFoto());
        OldPro.setDescripcion(pro.getDescripcion());

        repo.save(OldPro);
    }
}
