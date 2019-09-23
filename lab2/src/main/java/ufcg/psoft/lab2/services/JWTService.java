package ufcg.psoft.lab2.services;

import com.fasterxml.jackson.core.filter.TokenFilter;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.security.SignatureException;

@Service
public class JWTService {

    private UsuarioService usuarioService;
    private final int TOKEN_INDEX = 7;
    private final String TOKEN_KEY = "quero cachaca";

    public JWTService(UsuarioService usuarioService) {
        super();
        this.usuarioService = usuarioService;
    }

    public boolean usuarioExiste(String authorizationHeader) throws ServletException {
        String subject = getSujeitoDoToken(authorizationHeader);

        return usuarioService.getUsuario(subject).isPresent();
    }

    private String getSujeitoDoToken(String authorizationHeader) throws ServletException {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new ServletException("Token inexistente ou mal formatado!");
        }

        String token = authorizationHeader.substring(TOKEN_INDEX);

        String subject = null;
        subject = Jwts.parser().setSigningKey("quero cachaca").parseClaimsJws(token).getBody().getSubject();
        return subject;
    }
}
