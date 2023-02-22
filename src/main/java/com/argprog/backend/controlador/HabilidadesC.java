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

import com.argprog.backend.entidades.Habilidades;
import com.argprog.backend.servicios.HabilidadesServ;

@RestController
@RequestMapping("/per/hab")
public class HabilidadesC {
    
    @Autowired
    private HabilidadesServ serv;

    @GetMapping("/getAll")
    public List<Habilidades> getAll() {
        return serv.getHabilidades();
    }

    @GetMapping("/get/{id}")
    public Habilidades get(@PathVariable int id) {
        return serv.getHabilidad(id);
    }

    @PostMapping("/save")
    public String save(@RequestParam Habilidades hab) {
        serv.save(hab);
        return "Habilidad guardada con exito";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam Habilidades hab) {
        serv.edit(hab);
        return "Habilidad editada con exito";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        serv.delete(id);
        return "Habilidad borrada con exito";
    }
}
