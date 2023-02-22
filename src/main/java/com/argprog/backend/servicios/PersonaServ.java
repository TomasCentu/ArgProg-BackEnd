package com.argprog.backend.servicios;

import com.argprog.backend.entidades.Persona;
import com.argprog.backend.repositorios.PersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServ {

        @Autowired
        private PersonaRepo repo;
        
        public List<Persona> getPersonas() {
                return repo.findAll();
        }
        
        public Persona getPersona(int id) {
                return repo.findById(id).orElse(null);
        }
        
        public void save(Persona persona) {
                repo.save(persona);
        }
        
        public void delete(int id) {
                repo.deleteById(id);
        }
        
        public void edit(Persona persona) {
                Persona OldPersona = repo.findById(persona.getId()).orElse(null);
                OldPersona.setNombre(persona.getNombre());
                OldPersona.setCargo(persona.getCargo());
                OldPersona.setFoto(persona.getFoto());
                
                repo.save(OldPersona);
        }
}
