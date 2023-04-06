package com.argprog.myportfolio.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nombre;
    @NotNull
    private String cargo;
    @NotNull
    private String foto;
    @NotNull
    private String sobreMi;
    @NotNull
    private String banner;

    @OneToOne
    private Usuario usuario;

    public Persona() {
    }

    public Persona(String nombre, String cargo, String foto, String banner, String sobreMi) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.foto = foto;
        this.banner = banner;
        this.sobreMi = sobreMi;
    }
}
