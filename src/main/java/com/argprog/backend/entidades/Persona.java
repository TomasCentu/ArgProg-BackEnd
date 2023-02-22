package com.argprog.backend.entidades;

import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter @Setter
public class Persona {
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        private String nombre;
        private String cargo;
        private String foto;
        
        @OneToMany(mappedBy = "persona")
        private HashSet<Proyectos> proyectos;

        @OneToMany(mappedBy = "persona")
        private HashSet<Experiencias> expeciencias;

        @OneToMany(mappedBy = "persona")
        private HashSet<Estudios>estudios;
        
        @OneToMany(mappedBy = "persona")
        private HashSet<Habilidades> habilidades;

        public Persona() {  }

        public Persona(String nombre, String cargo, String foto) {
                this.nombre = nombre;
                this.cargo = cargo;
                this.foto = foto;
        }

        public Persona(String nombre, String cargo, String foto, HashSet<Proyectos> proyectos,
                        HashSet<Experiencias> expeciencias, HashSet<Estudios> estudios,
                        HashSet<Habilidades> habilidades) {
                this.nombre = nombre;
                this.cargo = cargo;
                this.foto = foto;
                this.proyectos = proyectos;
                this.expeciencias = expeciencias;
                this.estudios = estudios;
                this.habilidades = habilidades;
        }
        
        
}
