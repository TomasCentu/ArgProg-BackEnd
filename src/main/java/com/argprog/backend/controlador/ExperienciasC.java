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

import com.argprog.backend.entidades.Experiencias;
import com.argprog.backend.servicios.ExperienciasServ;
import com.argprog.backend.servicios.PersonaServ;

@RestController
@RequestMapping("/per/exp")
public class ExperienciasC {

    @Autowired
    private ExperienciasServ serv;

    @Autowired
    private PersonaServ servP;

    @GetMapping("/getAll")
    public List<Experiencias> getAll() {
        return serv.getExperiencias();
    }

    @GetMapping("/get/{id}")
    public Experiencias get(@PathVariable int id) {
        return serv.getExperiencia(id);
    }

    @PostMapping("/save/{id}")
    public String save(@PathVariable int id, @RequestBody Experiencias exp) {
        serv.save(exp);
        servP.agregarExp(id, exp.getId());
        return "Experiencia guardada con exito";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @RequestBody Experiencias exp) {
        serv.edit(exp);
        servP.editarExp(id, exp.getId());
        return "Experiencia editada con exito";
    }

    @DeleteMapping("/delete/{id}/{idp}")
    public String delete(@PathVariable int id, @PathVariable int idp) {
        servP.deleteExp(idp, id);
        serv.delete(id);
        return "Experiencia borrada con exito";
    }
}
