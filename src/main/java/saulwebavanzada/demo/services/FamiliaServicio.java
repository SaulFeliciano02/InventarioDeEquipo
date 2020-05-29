package saulwebavanzada.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import saulwebavanzada.demo.entities.Familia;
import saulwebavanzada.demo.repositories.FamiliaRepositorio;

import java.util.List;
import java.util.Optional;

public class FamiliaServicio {
    @Autowired
    private FamiliaRepositorio familiaRepositorio;

    public List<Familia> getFamilias(){
        return familiaRepositorio.findAll();
    }

    public Familia getFamiliaByNombre(String nombre){
        return familiaRepositorio.findByNombre(nombre);
    }

    public Familia getFamiliaById(long id){
        return familiaRepositorio.findById(id);
    }

    @Transactional
    public boolean crearFamilia(Familia familia){
        if(familiaRepositorio.findById(familia.getId()) != null){
            return false;
        }
        familiaRepositorio.save(familia);
        return true;
    }

    @Transactional
    public boolean eliminarFamilia(long id){
        Familia familia = familiaRepositorio.findById(id);
        if(familia != null){
            familiaRepositorio.delete(familia);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean editarFamilia(Familia familia){
        Optional<Familia> e = Optional.ofNullable(familiaRepositorio.findById(familia.getId()));
        if(e.isPresent()){
            Familia nuevaFamilia = e.get();
            nuevaFamilia.setNombre(familia.getNombre());
            return true;
        }
        return false;
    }
}
