package ufcg.psoft.lab2.services;

import org.springframework.stereotype.Service;
import ufcg.psoft.lab2.entities.Usuario;
import ufcg.psoft.lab2.repository.UsuarioRepository;

import javax.servlet.ServletException;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository<Usuario, String> usuarioDAO;

    public UsuarioService(UsuarioRepository<Usuario, String> usuarioDAO) {
        super();
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario adicionaUsuario(Usuario usuario) {
        this.usuarioDAO.save(usuario);
        return usuario;
    }

    public Optional<Usuario> getUsuario(String email) { return this.usuarioDAO.findByEmail(email); }

}
