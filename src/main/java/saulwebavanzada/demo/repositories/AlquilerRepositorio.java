package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import saulwebavanzada.demo.entities.Alquiler;

import java.util.List;

public interface AlquilerRepositorio extends JpaRepository<Alquiler, Long> {
    Alquiler findById(long id);

    //List<Alquiler> findAllOrderByFechaRealizacion();

    @Query("select a from Alquiler a where a.miCliente.id = :id")
    List<Alquiler> findByCliente(@Param("id") long id);
}
