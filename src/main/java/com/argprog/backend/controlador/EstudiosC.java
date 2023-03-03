package com.argprog.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprog.backend.entidades.Estudios;
import com.argprog.backend.servicios.EstudiosServ;
import com.argprog.backend.servicios.PersonaServ;

@RestController
@RequestMapping("/per/est")
public class EstudiosC {

    @Autowired
    private EstudiosServ serv;

    @Autowired
    private PersonaServ servP;

    @GetMapping("/getAll")
    public List<Estudios> getAll() {
        return serv.getEstudios();
    }

    @GetMapping("/get/{id}")
    public Estudios get(@PathVariable int id) {
        return serv.getEstudio(id);
    }

    @PostMapping("/save/{id}")
    public String save(@PathVariable int id, @RequestBody Estudios est) {
        serv.save(est);
        servP.agregarEst(id, est.getId());
        return "Estudio guardada con exito";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @RequestBody Estudios est) {
        serv.edit(est);
        servP.editarEst(id, est.getId());
        return "Estudio editada con exito";
    }

    @DeleteMapping("/delete/{id}/{idp}")
    public String delete(@PathVariable int id, @PathVariable int idp) {
        servP.deleteEst(idp, id);
        serv.delete(id);
        return "Estudio borrada con exito";
    }
}
