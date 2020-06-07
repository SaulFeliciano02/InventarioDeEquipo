package saulwebavanzada.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import saulwebavanzada.demo.entities.Role;
import saulwebavanzada.demo.entities.Usuario;
import saulwebavanzada.demo.repositories.RoleRepositorio;
import saulwebavanzada.demo.repositories.UsuarioRepositorio;
import saulwebavanzada.demo.services.RoleServicio;
import saulwebavanzada.demo.services.SeguridadServicio;
import saulwebavanzada.demo.services.UsuarioServicio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class InventarioDeEquipoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioDeEquipoApplication.class, args);

//        ApplicationContext applicationContext = SpringApplication.run(InventarioDeEquipoApplication.class, args);
//        RoleServicio roleServicio = (RoleServicio) applicationContext.getBean("roleServicio");
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        //roleServicio.crearRole(roleAdmin);
//
//        UsuarioServicio usuarioServicio = (UsuarioServicio) applicationContext.getBean("usuarioServicio");
//        Usuario usuarioAdmin = new Usuario("admin", "admin", new HashSet<>(Arrays.asList(roleAdmin)));
//        //usuarioServicio.crearUsuario(usuarioAdmin);

    }
}
