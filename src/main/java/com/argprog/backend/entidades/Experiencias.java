package com.argprog.backend.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Experiencias {
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        private String nombre;
        private String descripcion;
        private String foto;
        
        @ManyToOne(targetEntity = Persona.class)
        private Persona persona;

        public Experiencias() {  }

        public Experiencias(String nombre, String descripcion, String foto) {
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.foto = foto;
        }

        public Experiencias(String nombre, String descripcion, String foto, Persona persona) {
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.foto = foto;
                this.persona = persona;
        }
        
        
}
