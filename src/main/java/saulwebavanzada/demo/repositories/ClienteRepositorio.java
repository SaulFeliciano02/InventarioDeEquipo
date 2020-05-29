package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saulwebavanzada.demo.entities.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Cliente findByNombre(String nombre);
    Cliente findByCedula(String cedula);
    Cliente findById(long id);
}
