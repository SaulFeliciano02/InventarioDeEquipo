package saulwebavanzada.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saulwebavanzada.demo.entities.*;
import saulwebavanzada.demo.repositories.AlquilerRepositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class AlquilerServicio {

    @Autowired
    public AlquilerRepositorio alquilerRepositorio;

    public List<Alquiler> getAlquileres(){
        return alquilerRepositorio.findAllOrderedByFechaRealizacion();
    }

    public Alquiler getAlquilerById(long id){
        return alquilerRepositorio.findById(id);
    }

    public List<Alquiler> getAlquilerByEquipo(Equipo equipo){
        return alquilerRepositorio.findAllByEquipo(equipo);
    }

    public List<Alquiler> getAlquilerByCliente(Cliente cliente){
        return alquilerRepositorio.findAllByMiCliente(cliente);
    }

    public int getPromedioDiasBySubFamilia(List<Equipo> equipos){
        int diasPromedio = 0;
        int size = 0;
        for(Equipo e : equipos){
            List<Alquiler> alquileresByEquipo = getAlquilerByEquipo(e);
            size += alquileresByEquipo.size();
            for(Alquiler alquiler : alquileresByEquipo){
                diasPromedio += DAYS.between(alquiler.getFechaRealizacion().toInstant(), alquiler.getFechaEntregaPrometida().toInstant());
            }
        }
        try{
            diasPromedio /= size;
        }catch(Exception e){

        }

        return diasPromedio;
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
