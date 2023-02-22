package com.argprog.backend.controlador;

import com.argprog.backend.entidades.Persona;
import com.argprog.backend.servicios.PersonaServ;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/per")
public class PersonaC {

        @Autowired
        private PersonaServ serv;
        
        @GetMapping("/getAll")
        public List<Persona> getAll() {
                return serv.getPersonas();
        }
        
        @GetMapping("/get/{id}")
        public Persona get(@PathVariable int id) {
                return serv.getPersona(id);
        }
        
        @PostMapping("/save")
        public String save(@RequestParam Persona persona) {
                serv.save(persona);
                return "Persona guardada con exito";
        }
        
        @PostMapping("/edit")
        public String edit(@RequestParam Persona persona) {
                serv.edit(persona);
                return "Persona editada con exito";
        }
        
        @DeleteMapping("/delete/{id}")
        public String delete(@PathVariable int id) {
                serv.delete(id);
                return "Persona borrada con exito";
        }
}
