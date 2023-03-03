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

import com.argprog.backend.entidades.Habilidades;
import com.argprog.backend.servicios.HabilidadesServ;
import com.argprog.backend.servicios.PersonaServ;

@RestController
@RequestMapping("/per/hab")
public class HabilidadesC {
    
    @Autowired
    private HabilidadesServ serv;

    @Autowired
    private PersonaServ servP;

    @GetMapping("/getAll")
    public List<Habilidades> getAll() {
        return serv.getHabilidades();
    }

    @GetMapping("/get/{id}")
    public Habilidades get(@PathVariable int id) {
        return serv.getHabilidad(id);
    }

    @PostMapping("/save/{id}")
    public String save(@PathVariable int id, @RequestBody Habilidades hab) {
        serv.save(hab);
        servP.agregarHab(id, hab.getId());
        return "Habilidad guardada con exito";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @RequestBody Habilidades hab) {
        serv.edit(hab);
        servP.editarHab(id, hab.getId());
        return "Habilidad editada con exito";
    }

    @DeleteMapping("/delete/{id}/{idp}")
    public String delete(@PathVariable int id, @PathVariable int idp) {
        servP.deleteHab(idp, id);
        serv.delete(id);
        return "Habilidad borrada con exito";
    }
}
