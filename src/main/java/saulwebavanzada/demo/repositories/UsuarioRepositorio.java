package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saulwebavanzada.demo.entities.Usuario;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByRole(String role);

    List<Usuario> findAllByUsername(String username);

    Usuario findById(long id);
}
