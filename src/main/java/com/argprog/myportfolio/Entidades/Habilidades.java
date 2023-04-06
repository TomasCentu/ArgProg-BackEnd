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
public class Habilidades {
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @NotNull
        private String nombre;
        @NotNull
        private int porcentaje;

        public Habilidades() {  }

        public Habilidades(String nombre, int porcentaje) {
                this.nombre = nombre;
                this.porcentaje = porcentaje;
        }
        
}
