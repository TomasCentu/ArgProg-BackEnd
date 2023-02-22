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

import com.argprog.backend.entidades.Estudios;
import com.argprog.backend.servicios.EstudiosServ;

@RestController
@RequestMapping("/per/est")
public class EstudiosC {

    @Autowired
    private EstudiosServ serv;

    @GetMapping("/getAll")
    public List<Estudios> getAll() {
        return serv.getEstudios();
    }

    @GetMapping("/get/{id}")
    public Estudios get(@PathVariable int id) {
        return serv.getEstudio(id);
    }

    @PostMapping("/save")
    public String save(@RequestParam Estudios est) {
        serv.save(est);
        return "Estudio guardada con exito";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam Estudios est) {
        serv.edit(est);
        return "Estudio editada con exito";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        serv.delete(id);
        return "Estudio borrada con exito";
    }
}
