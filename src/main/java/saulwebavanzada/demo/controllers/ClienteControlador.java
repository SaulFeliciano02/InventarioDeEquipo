package saulwebavanzada.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import saulwebavanzada.demo.entities.Alquiler;
import saulwebavanzada.demo.entities.Cliente;
import saulwebavanzada.demo.services.AlquilerServicio;
import saulwebavanzada.demo.services.ClienteServicio;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/clientes")
public class ClienteControlador {
    @Autowired public ClienteServicio clienteServicio;
    @Autowired public AlquilerServicio alquilerServicio;

    @RequestMapping(path = "")
    public String listarClientes(Model model, @ModelAttribute("error") String error){
        model.addAttribute("listaClientes", clienteServicio.getClientes());
        if(!error.equalsIgnoreCase("")){
            model.addAttribute("error", error);
        }
        return "/thymeleaf/clients";
    }


        @RequestMapping("/crear")
    public String crearCliente(Model model, @RequestParam(name = "nombre") String nombre,
                               @RequestParam(name = "apellido") String apellido,
                               @RequestParam(name = "cedula") String cedula,
                               @RequestParam(name = "imagen") MultipartFile file) throws IOException{
        /**try{
            byte[] imagen = new byte[file.getBytes().length];
            int i = 0;
            for (byte b : file.getBytes()){
                imagen[i++] = b;
            }

        }catch(IOException e){
            e.printStackTrace();
        }**/
        String imagen = Base64.getEncoder().encodeToString(file.getBytes());
        List<Alquiler> alquiler = new ArrayList<Alquiler>();

        byte[] encoded = Base64.getEncoder().encode(file.getBytes());
        Cliente cliente= new Cliente(nombre, apellido, cedula, alquiler, imagen, file.getContentType());

        clienteServicio.crearCliente(cliente);
        return "redirect:/clientes";
    }

    @RequestMapping(path = "/editar")
    public String editarCliente(Model model, @RequestParam(name = "id") long id,
                                @RequestParam(name = "nombre") String nombre,
                                   @RequestParam(name = "apellido") String apellido,
                                   @RequestParam(name = "cedula") String cedula,
                                   @RequestParam(name = "imagen") MultipartFile file) throws IOException {
        Cliente clienteSearch = clienteServicio.getClienteById(id);
        String imagen = Base64.getEncoder().encodeToString(file.getBytes());
        Cliente cliente = new Cliente(nombre, apellido, cedula, clienteSearch.getAlquileres(), imagen, file.getContentType());
        clienteServicio.editarCliente(cliente, id);
        return "redirect:/clientes";
    }

    @RequestMapping(path = "/eliminar/{id}")
    public RedirectView eliminarEstudiante(Model model, @PathVariable(name = "id") long id, RedirectAttributes attributes){
        Cliente cliente = clienteServicio.getClienteById(id);
        if(alquilerServicio.getAlquilerByCliente(cliente).size() > 0){
            attributes.addFlashAttribute("error", "Cliente relacionado a Alquiler, no se puede eliminar.");
        }else{
            clienteServicio.eliminarCliente(id);
        }
        return new RedirectView("/clientes");
    }

}
