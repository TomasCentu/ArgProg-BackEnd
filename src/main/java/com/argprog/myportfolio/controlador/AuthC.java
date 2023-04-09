package com.argprog.myportfolio.controlador;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprog.myportfolio.Entidades.JwtDto;
import com.argprog.myportfolio.Entidades.Mensaje;
import com.argprog.myportfolio.Entidades.Rol;
import com.argprog.myportfolio.Entidades.Usuario;
import com.argprog.myportfolio.Enum.Roles;
import com.argprog.myportfolio.seguridad.JwtUtil;
import com.argprog.myportfolio.servicios.RolServ;
import com.argprog.myportfolio.servicios.UsuarioServ;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("https://argprograma-bb7bb.web.app")
@RequestMapping("/auth")
public class AuthC {

    @Autowired
    private PasswordEncoder passE;

    @Autowired
    private AuthenticationManager authM;

    @Autowired
    private UsuarioServ userServ;

    @Autowired
    private RolServ rolServ;

    @Autowired
    private JwtUtil jwtP;

    @PostMapping("/new")
    public ResponseEntity<?> newUser(@Valid @RequestBody Usuario user, BindingResult binding) {

        if (binding.hasErrors()) {
            return new ResponseEntity<>(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        }

        if (userServ.existUsuario(user.getNombre())) {
            return new ResponseEntity<>(new Mensaje("Usuario existente"), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(user.getNombre(), passE.encode(user.getPass()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolServ.getRol(Roles.ROLE_ADMIN).get());

        usuario.setRoles(roles);
        userServ.save(usuario);

        return new ResponseEntity<>(new Mensaje("Usuario Guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Usuario user, BindingResult binding) {

        if (binding.hasErrors()) {
            return new ResponseEntity<>(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        }

        Authentication auth = authM.authenticate(new UsernamePasswordAuthenticationToken(user.getNombre(), user.getPass()));

        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt = jwtP.generateJwtToken(auth);

        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
}
