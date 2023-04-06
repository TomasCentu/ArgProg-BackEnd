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
public class Experiencias {
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        @NotNull
        private String nombre;
        @NotNull
        private String descripcion;
        @NotNull
        private String foto;

        public Experiencias() {  }

        public Experiencias(String nombre, String descripcion, String foto) {
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.foto = foto;
        }
}
