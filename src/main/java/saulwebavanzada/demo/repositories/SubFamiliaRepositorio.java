package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import saulwebavanzada.demo.entities.SubFamilia;

import java.util.List;

public interface SubFamiliaRepositorio extends JpaRepository<SubFamilia, Long> {
    SubFamilia findById(long id);
    SubFamilia findByNombre(String nombre);

    @Query("select s from SubFamilia s where s.miFamilia.id = :familiaId")
    List<SubFamilia> getSubFamiliaByFamilia(@Param("familiaId") long id);
}
