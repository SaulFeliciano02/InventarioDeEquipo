package saulwebavanzada.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import saulwebavanzada.demo.entities.Role;
import saulwebavanzada.demo.entities.Usuario;
import saulwebavanzada.demo.services.UsuarioServicio;

import java.util.Set;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {
    @Autowired
    public UsuarioServicio usuarioServices;

    //@Secured({"ROLE_ADMIN"})
    @RequestMapping("")
    public String listarUsuarios(Model model){
        model.addAttribute("listaUsuarios", usuarioServices.getUsuario());
        return "/thymeleaf/users.html";
    }

    //@Secured({"ROLE_ADMIN"})
    @RequestMapping("/crear")
    public String crearUsuario(Model model, @RequestParam(name = "username") String username,
                               @RequestParam(name = "contrasena") String password,
                               @RequestParam(name = "role") Set<Role> role){
        Usuario usuario = new Usuario(username, password, role);
        usuarioServices.crearUsuario(usuario);
        return "redirect:/usuarios";
    }

   /** @RequestMapping(path = "/editar")
    public String editarCliente(Model model, @RequestParam(name = "id") long id,
                                @RequestParam(name = "nombre") String username,
                                @RequestParam(name = "apellido") String oldPassword,
                                @RequestParam(name = "cedula") String password,
                                @RequestParam(name = "imagen") String passwordCheck){
        Cliente clienteSearch = clienteServicio.getClienteById(id);
        Cliente cliente = new Cliente(nombre, apellido, cedula, clienteSearch.getAlquileres(), null);
        clienteServicio.editarCliente(cliente, id);
        return "redirect:/clientes";
    }**/

    //@Secured({"ROLE_ADMIN"})
    @RequestMapping(path = "/eliminar/{id}")
    public String eliminarUsuario(Model model, @PathVariable(name = "id") long id){
        usuarioServices.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}
