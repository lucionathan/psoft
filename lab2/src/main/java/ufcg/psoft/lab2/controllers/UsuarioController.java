package ufcg.psoft.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ufcg.psoft.lab2.entities.Usuario;
import ufcg.psoft.lab2.services.JWTService;
import ufcg.psoft.lab2.services.UsuarioService;

import javax.servlet.ServletException;
import java.util.Optional;

@RestController
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        super();
        this.usuarioService = usuarioService;
    }

    @PostMapping("/api/usuarios")
    public ResponseEntity<Usuario> adicionaUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<Usuario>(this.usuarioService.adicionaUsuario(usuario), HttpStatus.OK);
    }


}