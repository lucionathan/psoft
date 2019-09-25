package ufcg.psoft.lab2.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufcg.psoft.lab2.entities.Disciplina;
import ufcg.psoft.lab2.entities.Usuario;
import ufcg.psoft.lab2.services.JWTService;
import ufcg.psoft.lab2.services.UsuarioService;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final String TOKEN_KEY = "quero cachaca";

    private UsuarioService usuariosService;
    private JWTService jwtService;

    public LoginController(UsuarioService usuariosService, JWTService jwtService) {
        super();
        this.usuariosService = usuariosService;
        this.jwtService = jwtService;
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

    @DeleteMapping("/usuarios/{email}")
    public ResponseEntity<Usuario> deletaUsuario(@PathVariable String email, @RequestHeader String header) throws ServletException {
        if(header == null || !header.startsWith("Bearer ") || this.jwtService.usuarioTemPermissao(header, email)) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        String subject = this.jwtService.getSujeitoDoToken(header);

        return new ResponseEntity(this.usuariosService.deletaUsuario(subject), HttpStatus.OK);
    }

}
