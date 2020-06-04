package saulwebavanzada.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import saulwebavanzada.demo.entities.Alquiler;
import saulwebavanzada.demo.entities.Usuario;
import saulwebavanzada.demo.repositories.AlquilerRepositorio;

import java.util.List;
import java.util.Optional;

public class AlquilerServicio {
    @Autowired
    public AlquilerRepositorio alquilerRepositorio;

    public List<Alquiler> getAlquileres(){
        return alquilerRepositorio.findAll();
    }

    @Transactional
    public boolean crearAlquiler(Alquiler alquiler){
        if(alquilerRepositorio.findById(alquiler.getId()) != null){
            return false;
        }
        alquilerRepositorio.save(alquiler);
        return true;
    }

    @Transactional
    public boolean eliminarAlquiler(long id){
        Alquiler alquiler = alquilerRepositorio.findById(id);
        if(alquiler != null){
            alquilerRepositorio.delete(alquiler);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean editarAlquiler(Alquiler alquiler){
        Optional<Alquiler> e = Optional.ofNullable(alquilerRepositorio.findById(alquiler.getId()));
        if(e.isPresent()){
            Alquiler alquilerNuevo = e.get();
            alquilerNuevo.setEquipo(alquiler.getEquipo());
            alquilerNuevo.setFechaEntregaPrometida(alquiler.getFechaEntregaPrometida());
            alquilerNuevo.setFechaEntregaReal(alquiler.getFechaEntregaReal());
            alquilerNuevo.setFechaRealizacion(alquiler.getFechaRealizacion());
            alquilerNuevo.setMiCliente(alquiler.getMiCliente());
            alquilerNuevo.setPagado(alquiler.isPagado());
            return true;
        }
        return false;
    }
}
