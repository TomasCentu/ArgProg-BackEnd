package com.argprog.myportfolio.Entidades;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtDto {

    private String token;
    private String bearer = "Bearer ";
    private String nombre; 
    private Collection<? extends GrantedAuthority> auth;

    public JwtDto(String token, String nombre, Collection<? extends GrantedAuthority> auth) {
        this.token = token;
        this.nombre = nombre;
        this.auth = auth;
    }

    public JwtDto() {
    }

    
}
