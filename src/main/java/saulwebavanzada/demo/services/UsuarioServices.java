package saulwebavanzada.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import saulwebavanzada.demo.entities.Equipo;
import saulwebavanzada.demo.entities.Usuario;
import saulwebavanzada.demo.repositories.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

public class UsuarioServices {

    @Autowired
    public UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> getUsuario(){
        return usuarioRepositorio.findAll();
    }

    @Transactional
    public boolean crearUsuario(Usuario usuario){
        if(usuarioRepositorio.findById(usuario.getId()) != null){
            return false;
        }
        usuarioRepositorio.save(usuario);
        return true;
    }

    @Transactional
    public boolean eliminarUsuario(long id){
        Usuario usuario = usuarioRepositorio.findById(id);
        if(usuario != null){
            usuarioRepositorio.delete(usuario);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean editarEquipo(Usuario usuario){
        Optional<Usuario> e = Optional.ofNullable(usuarioRepositorio.findById(usuario.getId()));
        if(e.isPresent()){
            Usuario nuevoUsuario = e.get();
            nuevoUsuario.setUsername(usuario.getUsername());
            nuevoUsuario.setUsername(usuario.getUsername());
            nuevoUsuario.setRole(usuario.getRole());
            return true;
        }
        return false;
    }
}
