package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import saulwebavanzada.demo.entities.Alquiler;
import saulwebavanzada.demo.entities.Cliente;
import saulwebavanzada.demo.entities.Equipo;
import saulwebavanzada.demo.entities.SubFamilia;

import java.util.Date;
import java.util.List;

public interface AlquilerRepositorio extends JpaRepository<Alquiler, Long> {
    Alquiler findById(long id);

    List<Alquiler> findAllByFechaEntregaPrometida(Date fechaPrometida);
    List<Alquiler> findAllByFechaRealizacion(Date fechaRealizacion);
    List<Alquiler> findAllByEquipo(Equipo equipo);

    @Query("select a from Alquiler a order by a.fechaRealizacion")
    List<Alquiler> findAllOrderedByFechaRealizacion();

    List<Alquiler> findAllByMiCliente(Cliente cliente);
}
