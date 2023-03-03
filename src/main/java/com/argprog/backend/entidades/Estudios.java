package com.argprog.backend.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Estudios {
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        private String nombre;
        private String descripcion;
        private String foto;

        public Estudios() {  }

        public Estudios(String nombre, String descripcion, String foto) {
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.foto = foto;
        }
    
        
}
