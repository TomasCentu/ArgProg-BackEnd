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

import com.argprog.backend.entidades.Experiencias;
import com.argprog.backend.servicios.ExperienciasServ;

@RestController
@RequestMapping("/per/exp")
public class ExperienciasC {

    @Autowired
    private ExperienciasServ serv;

    @GetMapping("/getAll")
    public List<Experiencias> getAll() {
        return serv.getExperiencias();
    }

    @GetMapping("/get/{id}")
    public Experiencias get(@PathVariable int id) {
        return serv.getExperiencia(id);
    }

    @PostMapping("/save")
    public String save(@RequestParam Experiencias exp) {
        serv.save(exp);
        return "Experiencia guardada con exito";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam Experiencias exp) {
        serv.edit(exp);
        return "Experiencia editada con exito";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        serv.delete(id);
        return "Experiencia borrada con exito";
    }
}
