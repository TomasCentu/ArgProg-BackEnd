package com.argprog.myportfolio.controlador;

import com.argprog.myportfolio.Entidades.Persona;
import com.argprog.myportfolio.servicios.PersonaServ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("https://argprograma-bb7bb.web.app")
@RequestMapping("/per")
public class PersonaC {

    @Autowired
    private PersonaServ serv;
        
    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('USER')")
    public Persona get(@PathVariable int id) {
        return serv.getPersona(id);
    }

    @GetMapping("/exist/{id}")
    public Boolean exist(@PathVariable int id) {
        return serv.exist(id);
    }
        
    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public void save(@RequestBody Persona persona) {
        serv.save(persona);
    }

    @PostMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public void edit(@RequestBody Persona persona) {
        serv.edit(persona);
    }
}
