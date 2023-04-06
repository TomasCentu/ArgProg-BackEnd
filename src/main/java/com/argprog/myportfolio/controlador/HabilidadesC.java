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

import com.argprog.myportfolio.Entidades.Habilidades;
import com.argprog.myportfolio.servicios.HabilidadesServ;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/per/hab")
public class HabilidadesC {

    @Autowired
    private HabilidadesServ serv;

    @GetMapping("/getAll")
    public List<Habilidades> getAll() {
        return serv.getHabilidades();
    }
        
    @PostMapping("/save")
    public void save(@RequestBody Habilidades habilidades) {
        serv.save(habilidades);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        serv.delete(id);
    }
}
