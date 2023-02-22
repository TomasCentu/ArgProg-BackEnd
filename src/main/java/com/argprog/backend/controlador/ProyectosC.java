package com.argprog.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.argprog.backend.entidades.Proyectos;
import com.argprog.backend.servicios.ProyectosServ;

@RestController
@RequestMapping("/per/pro")
public class ProyectosC {
    
    @Autowired
    private ProyectosServ serv;

    @GetMapping("/getAll")
    public List<Proyectos> getAll() {
        return serv.getProyectos();
    }

    @GetMapping("/get/{id}")
    public Proyectos get(@PathVariable int id) {
        return serv.getProyecto(id);
    }

    @PostMapping("/save")
    public String save(@RequestParam Proyectos pro) {
        serv.save(pro);
        return "Proyecto guardada con exito";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam Proyectos pro) {
        serv.edit(pro);
        return "Proyecto editada con exito";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        serv.delete(id);
        return "Proyecto borrada con exito";
    }
}
