package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saulwebavanzada.demo.entities.Alquiler;
import saulwebavanzada.demo.entities.Factura;

import java.util.List;

public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
    Factura findByAlquiler(Alquiler alquiler);
    Factura findById(long id);
    List<Factura> findAllByAlquiler(Alquiler alquiler);
}


