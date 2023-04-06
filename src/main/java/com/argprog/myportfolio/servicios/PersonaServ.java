package com.argprog.myportfolio.servicios;

import com.argprog.myportfolio.Entidades.Persona;
import com.argprog.myportfolio.repositorios.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServ {

    @Autowired
    private PersonaRepo repo;

    public Persona getPersona(int id) {
        return repo.findById(id).orElse(null);
    }

    public boolean exist(int id) {
        return repo.existsById(id);
    }

    public void save(Persona persona) {
        repo.save(persona);
    }

    public void edit(Persona persona) {
        Persona OldPersona = repo.findById(persona.getId()).orElse(null);

        if (persona.getFoto() != "") {
            OldPersona.setFoto(persona.getFoto());
        }

        if (persona.getBanner() != "") {
            OldPersona.setBanner(persona.getBanner());
        }

        OldPersona.setNombre(persona.getNombre());
        OldPersona.setCargo(persona.getCargo());
        OldPersona.setSobreMi(persona.getSobreMi());

        repo.save(OldPersona);
    }
}
