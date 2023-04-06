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

import com.argprog.myportfolio.Entidades.Proyectos;
import com.argprog.myportfolio.servicios.ProyectosServ;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/per/pro")
public class ProyectosC {
    
    @Autowired
    private ProyectosServ serv;

    @GetMapping("/getAll")
    public List<Proyectos> getAll() {
        return serv.getProyectos();
    }
        
    @PostMapping("/save")
    public void save(@RequestBody Proyectos proyectos) {
        serv.save(proyectos);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        serv.delete(id);
    }
}
