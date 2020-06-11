package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import saulwebavanzada.demo.entities.Alquiler;
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

    //List<Alquiler> findAllOrderByFechaRealizacion();

   /** @Query("select a from Alquiler a where a.miCliente.id = :id")
    List<Alquiler> findByCliente(@Param("id") long id);

    @Query("Select alquiler.id, alquiler.fecha_entrega_prometida, alquiler.fecha_entrega_real, alquiler.fecha_realizacion, alquiler.pagado, equipo.nombre as equipo, sub_familia.nombre as sub_familia from alquiler" +
            " inner join equipo on equipo.id = alquiler.equipo_id inner join" +
            " sub_familia on equipo.mi_sub_familia_id = sub_familia.id order by alquiler.fecha_realizacion")
    List<Alquiler> getAlquileresBySubFamilia();

    //@Query("select a from Alquiler a JOIN Equipo e JOIN SubFamilia s.nombre where where s.nombre =:subFamiliaNombre")

    @Query("select a from Alquiler a where a.equipo.miSubfamilia = :subFamilia")
    List<Alquiler> findAlquilersBySubFamiliaNombre(@Param("subFamilia") SubFamilia subFamiliaNombre);**/
}
