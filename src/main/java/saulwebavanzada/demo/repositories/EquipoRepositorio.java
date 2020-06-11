package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saulwebavanzada.demo.entities.Equipo;
import saulwebavanzada.demo.entities.SubFamilia;

import java.util.List;

public interface EquipoRepositorio extends JpaRepository<Equipo, Long> {
    Equipo findById(long id);
    Equipo findByNombre(String nombre);
    List<Equipo> findAllByMiSubFamilia(SubFamilia subFamilia);
}
