package com.argprog.myportfolio.servicios;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.argprog.myportfolio.Entidades.Usuario;

public class UserDetailsImp implements UserDetails {

    private int id;
    private String nombre;
    private String pass;
    private Collection<? extends GrantedAuthority> auth;    

    public UserDetailsImp(int id, String nombre, String pass, Collection<? extends GrantedAuthority> auth) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
        this.auth = auth;
    }

    public static UserDetailsImp build(Usuario user) {
        List<GrantedAuthority> auth = user.getRoles().stream().map(
           rol -> new SimpleGrantedAuthority(rol.getRol().name())
        ).collect(Collectors.toList());

        return new UserDetailsImp(user.getId(), user.getNombre(), user.getPass(), auth);
    }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return auth;
  }

  public int getId() {
    return id;
  }

  @Override
  public String getPassword() {
    return pass;
  }

  @Override
  public String getUsername() {
    return nombre;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImp user = (UserDetailsImp) o;
    return Objects.equals(id, user.id);
  }

}
