package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saulwebavanzada.demo.entities.Alquiler;
import saulwebavanzada.demo.entities.Factura;

public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
    Factura findByAlquiler(Alquiler alquiler);
    Factura findById(long id);
}


