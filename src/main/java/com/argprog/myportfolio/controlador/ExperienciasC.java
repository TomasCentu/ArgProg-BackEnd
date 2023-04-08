package com.argprog.myportfolio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprog.myportfolio.Entidades.Experiencias;
import com.argprog.myportfolio.servicios.ExperienciasServ;

@RestController
@CrossOrigin("https://argprograma-bb7bb.web.app")
@RequestMapping("/per/exp")
public class ExperienciasC {

    @Autowired
    private ExperienciasServ serv;

    @GetMapping("/getAll")
    public List<Experiencias> getAll() {
        return serv.getExperiencias();
    }
        
    @PostMapping("/save")
    public void save(@RequestBody Experiencias experiencias) {
        serv.save(experiencias);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        serv.delete(id);
    }
}
