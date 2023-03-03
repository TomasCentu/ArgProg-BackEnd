package com.argprog.backend.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyectos {
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        private String nombre;
        private String foto;
        private String demo;
        private String repo;
        private String descripcion;

        public Proyectos() {  }

        public Proyectos(String nombre, String foto, String demo, String repo, String descripcion) {
                this.nombre = nombre;
                this.foto = foto;
                this.demo = demo;
                this.repo = repo;
                this.descripcion = descripcion;
        }
  
}
