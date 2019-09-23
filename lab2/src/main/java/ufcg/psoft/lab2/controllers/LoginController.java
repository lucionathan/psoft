package ufcg.psoft.lab2.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufcg.psoft.lab2.entities.Usuario;
import ufcg.psoft.lab2.services.UsuarioService;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final String TOKEN_KEY = "quero cachaca";

    private UsuarioService usuariosService;

    public LoginController(UsuarioService usuariosService) {
        super();
        this.usuariosService = usuariosService;
    }

    @PostMapping("/login")
    public LoginResponse authenticate(@RequestBody Usuario usuario) throws ServletException {

        // Recupera o usuario
        Optional<Usuario> authUsuario = usuariosService.getUsuario(usuario.getEmail());

        // verificacoes
        if (authUsuario.isEmpty()) {
            throw new ServletException("Usuario nao encontrado!");
        }

        if (!authUsuario.get().getSenha().equals(usuario.getSenha())) {
            throw new ServletException("Senha invalida!");
        }

        String token = Jwts.builder().setSubject(authUsuario.get().getEmail()).signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 50 * 60 * 1000)).compact();

        return new LoginResponse(token);

    }

    private class LoginResponse {
        public String token;

        public LoginResponse(String token) {
            this.token = token;
        }
    }

}
