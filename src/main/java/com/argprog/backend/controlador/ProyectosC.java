package com.argprog.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprog.backend.entidades.Proyectos;
import com.argprog.backend.servicios.PersonaServ;
import com.argprog.backend.servicios.ProyectosServ;

@RestController
@RequestMapping("/per/pro")
public class ProyectosC {
    
    @Autowired
    private ProyectosServ serv;

    @Autowired
    private PersonaServ servP;

    @GetMapping("/getAll")
    public List<Proyectos> getAll() {
        return serv.getProyectos();
    }

    @GetMapping("/get/{id}")
    public Proyectos get(@PathVariable int id) {
        return serv.getProyecto(id);
    }

    @PostMapping("/save/{id}")
    public String save(@PathVariable int id, @RequestBody Proyectos pro) {
        serv.save(pro);
        servP.agregarPro(id, pro.getId());
        return "Proyecto guardada con exito";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @RequestBody Proyectos pro) {
        serv.edit(pro);
        servP.editarPro(id, pro.getId());
        return "Proyecto editada con exito";
    }

    @DeleteMapping("/delete/{id}/{idp}")
    public String delete(@PathVariable int id, @PathVariable int idp) {
        servP.deletePro(idp, id);
        serv.delete(id);
        return "Proyecto borrada con exito";
    }
}
