package saulwebavanzada.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saulwebavanzada.demo.entities.Cliente;
import saulwebavanzada.demo.entities.SubFamilia;
import saulwebavanzada.demo.repositories.SubFamiliaRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class SubFamiliaServicio {
    @Autowired
    private SubFamiliaRepositorio subFamiliaRepositorio;

    public List<SubFamilia> getSubFamilias(){
        return subFamiliaRepositorio.findAll();
    }

    public SubFamilia getSubFamiliaByNombre(String nombre){
        return subFamiliaRepositorio.findByNombre(nombre);
    }

    public SubFamilia getSubFamiliaById(long id){
        return subFamiliaRepositorio.findById(id);
    }

    public List<SubFamilia> getSubFamiliaByFamilia(long familiaId){
        return subFamiliaRepositorio.getSubFamiliaByFamilia(familiaId);
    }

    @Transactional
    public boolean crearSubFamilia(SubFamilia subFamilia){
        if(subFamiliaRepositorio.findById(subFamilia.getId()) != null){
            return false;
        }
        subFamiliaRepositorio.save(subFamilia);
        return true;
    }

    @Transactional
    public boolean eliminarSubFamilia(long id){
        SubFamilia subFamilia = subFamiliaRepositorio.findById(id);
        if(subFamilia != null){
            subFamiliaRepositorio.delete(subFamilia);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean editarSubFamilia(SubFamilia subFamilia){
        Optional<SubFamilia> e = Optional.ofNullable(subFamiliaRepositorio.findById(subFamilia.getId()));
        if(e.isPresent()){
            SubFamilia nuevaSubFamilia = e.get();
            nuevaSubFamilia.setNombre(subFamilia.getNombre());
            return true;
        }
        return false;
    }

}
