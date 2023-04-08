package com.argprog.myportfolio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprog.myportfolio.Entidades.Estudios;
import com.argprog.myportfolio.servicios.EstudiosServ;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin("https://argprograma-bb7bb.web.app")
@RequestMapping("/per/est")
public class EstudiosC {

    @Autowired
    private EstudiosServ serv;

    @GetMapping("/getAll")
    public List<Estudios> getAll() {
        return serv.getEstudios();
    }
        
    @PostMapping("/save")
    public void save(@RequestBody Estudios estudios) {
        serv.save(estudios);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        serv.delete(id);
    }
}
