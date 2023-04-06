package com.argprog.myportfolio.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.argprog.myportfolio.Entidades.Usuario;
import com.argprog.myportfolio.repositorios.UsuarioRepo;
import jakarta.transaction.Transactional;

@Service
public class UserDetailsImpServ implements UserDetailsService {

  @Autowired
  UsuarioRepo userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario user = userRepository.findByNombre(username).orElseThrow(
        () -> new UsernameNotFoundException("User Not Found with username: " + username)
    );

    return UserDetailsImp.build(user);
  }

}
