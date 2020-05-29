package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saulwebavanzada.demo.entities.Familia;

public interface FamiliaRepositorio extends JpaRepository<Familia, Long> {
    Familia findById(long id);
    Familia findByNombre(String nombre);
}
