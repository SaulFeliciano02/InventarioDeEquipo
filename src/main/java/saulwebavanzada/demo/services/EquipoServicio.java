package saulwebavanzada.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import saulwebavanzada.demo.entities.Cliente;
import saulwebavanzada.demo.entities.Equipo;
import saulwebavanzada.demo.repositories.EquipoRepositorio;

import java.util.List;
import java.util.Optional;

public class EquipoServicio {
    @Autowired
    public EquipoRepositorio equipoRepositorio;

    public List<Equipo> getEquipos(){
        return equipoRepositorio.findAll();
    }

    public Equipo getEquipoByNombre(String nombre){
        return equipoRepositorio.findByNombre(nombre);
    }

    public Equipo getEquipoById(long id){
        return equipoRepositorio.findById(id);
    }

    @Transactional
    public boolean crearEquipo(Equipo equipo){
        if(equipoRepositorio.findById(equipo.getId()) != null){
            return false;
        }
        equipoRepositorio.save(equipo);
        return true;
    }

    @Transactional
    public boolean eliminarEquipo(long id){
        Equipo equipo = equipoRepositorio.findById(id);
        if(equipo != null){
            equipoRepositorio.delete(equipo);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean editarEquipo(Equipo equipo){
        Optional<Equipo> e = Optional.ofNullable(equipoRepositorio.findById(equipo.getId()));
        if(e.isPresent()){
            Equipo nuevoEquipo = e.get();
            nuevoEquipo.setCostoAlquiler(equipo.getCostoAlquiler());
            nuevoEquipo.setNombre(equipo.getNombre());
            nuevoEquipo.setMiSubFamilia(equipo.getMiSubFamilia());
            nuevoEquipo.setImagen(equipo.getImagen());
            nuevoEquipo.setExistencia(equipo.getExistencia());
            return true;
        }
        return false;
    }

}
