package com.argprog.myportfolio.Entidades;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @NotNull
    private String nombre;

    @NotNull
    private String pass;

    private List<String> modo;

    @OneToOne
    private Persona persona;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario(@NotNull String nombre, @NotNull String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public Usuario() {
    }
    
}
