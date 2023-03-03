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

        // GET
        
        public List<Persona> getPersonas() {
                return repo.findAll();
        }
        
        public Persona getPersona(int id) {
                return repo.findById(id).orElse(null);
        }

        // SAVE
        
        public void save(Persona persona) {
                repo.save(persona);
        }

        public void agregarHab(int id, int hab) {
                Persona persona = repo.findById(id).orElse(null);
                persona.getHabilidades().add(hab);
                repo.save(persona);
        }

        public void agregarExp(int id, int exp) {
                Persona persona = repo.findById(id).orElse(null);
                persona.getExperiencias().add(exp);
                repo.save(persona);
        }

        public void agregarPro(int id, int pro) {
                Persona persona = repo.findById(id).orElse(null);
                persona.getProyectos().add(pro);
                repo.save(persona);
        }

        public void agregarEst(int id, int est) {
                Persona persona = repo.findById(id).orElse(null);
                persona.getEstudios().add(est);
                repo.save(persona);
        }

        // EDIT
        
        public void edit(Persona persona) {
                Persona OldPersona = repo.findById(persona.getId()).orElse(null);

                OldPersona.setNombre(persona.getNombre());
                OldPersona.setCargo(persona.getCargo());
                OldPersona.setFoto(persona.getFoto());
                
                repo.save(OldPersona);
        }

        public void editarEst(int id, int est) {
                Persona persona = repo.findById(id).orElse(null);

                if (persona.getEstudios().contains(est)) {
                        persona.getEstudios().add(est);
                }
        }

        public void editarHab(int id, int hab) {
                Persona persona = repo.findById(id).orElse(null);

                if (persona.getHabilidades().contains(hab)) {
                        persona.getHabilidades().add(hab);
                }
        }

        public void editarExp(int id, int exp) {
                Persona persona = repo.findById(id).orElse(null);

                if (persona.getExperiencias().contains(exp)) {
                        persona.getExperiencias().add(exp);
                }
        }

        public void editarPro(int id, int pro) {
                Persona persona = repo.findById(id).orElse(null);

                if (persona.getProyectos().contains(pro)) {
                        persona.getProyectos().add(pro);
                }
        }

        // DELETE
        
        public void delete(int id) {
                repo.deleteById(id);
        }

        public void deleteEst(int id, int est) {
                Persona persona = repo.findById(id).orElse(null);

                if (persona.getEstudios().contains(est)) {
                        persona.getEstudios().remove(est);
                }
        }

        public void deleteHab(int id, int hab) {
                Persona persona = repo.findById(id).orElse(null);

                if (persona.getHabilidades().contains(hab)) {
                        persona.getHabilidades().remove(hab);
                }
        }

        public void deleteExp(int id, int exp) {
                Persona persona = repo.findById(id).orElse(null);

                if (persona.getExperiencias().contains(exp)) {
                        persona.getExperiencias().remove(exp);
                }
        }

        public void deletePro(int id, int pro) {
                Persona persona = repo.findById(id).orElse(null);

                if (persona.getProyectos().contains(pro)) {
                        persona.getProyectos().remove(pro);
                }
        }
}
