package com.argprog.myportfolio.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyectos {
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        @NotNull
        private String nombre;
        @NotNull
        private String foto;
        @NotNull
        private String demo;
        @NotNull
        private String repo;
        @NotNull
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
