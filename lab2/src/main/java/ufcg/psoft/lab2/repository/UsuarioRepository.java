package ufcg.psoft.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufcg.psoft.lab2.entities.Usuario;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface UsuarioRepository<T, ID extends Serializable> extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByEmail(String email);

}
