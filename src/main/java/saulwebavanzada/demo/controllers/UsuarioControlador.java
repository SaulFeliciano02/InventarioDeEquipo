package saulwebavanzada.demo.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import saulwebavanzada.demo.entities.Usuario;
import saulwebavanzada.demo.services.UsuarioServicio;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {
    @Autowired
    public UsuarioServicio usuarioServices;

    @RequestMapping("")
    public String listarUsuarios(Model model){
        model.addAttribute("listaUsuarios", usuarioServices.getUsuario());
        return "/thymeleaf/users.html";
    }

    @RequestMapping("/crear")
    public String crearCliente(Model model, @RequestParam(name = "username") String username,
                               @RequestParam(name = "contrasena") String password,
                               @RequestParam(name = "role") String role){
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

    @RequestMapping(path = "/eliminar/{id}")
    public String eliminarEstudiante(Model model, @PathVariable(name = "id") long id){
        usuarioServices.eliminarUsuario(id);
        return "redirect:/listar";
    }
}
