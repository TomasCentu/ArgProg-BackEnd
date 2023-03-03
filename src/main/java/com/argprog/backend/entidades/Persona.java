package com.argprog.backend.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter @Setter
public class Persona {
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        @NotNull
        private String nombre;
        @NotNull
        private String cargo;

        private String foto;
        private String sobreMi;
        private String banner;
        
        private List<Integer> proyectos = new ArrayList<>();

        private List<Integer> experiencias = new ArrayList<>();

        private List<Integer> estudios = new ArrayList<>();
        
        private List<Integer> habilidades = new ArrayList<>();

        public Persona() {  }

        public Persona(String nombre, String cargo, String foto, String banner, String sobreMi) {
                this.nombre = nombre;
                this.cargo = cargo;
                this.foto = foto;
                this.banner = banner;
                this.sobreMi = sobreMi;
        }
}
