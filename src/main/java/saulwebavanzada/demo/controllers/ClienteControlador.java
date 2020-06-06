package saulwebavanzada.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import saulwebavanzada.demo.entities.Alquiler;
import saulwebavanzada.demo.entities.Cliente;
import saulwebavanzada.demo.services.ClienteServicio;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/clientes")
public class ClienteControlador {
    @Autowired
    public ClienteServicio clienteServicio;

    @RequestMapping(path = "")
    public String listarClientes(Model model){
        model.addAttribute("listaClientes", clienteServicio.getClientes());
        return "/thymeleaf/clients";
    }


        @RequestMapping("/crear")
    public String crearCliente(Model model, @RequestParam(name = "nombre") String nombre,
                               @RequestParam(name = "apellido") String apellido,
                               @RequestParam(name = "cedula") String cedula,
                               @RequestParam(name = "imagen") File file){
        byte[] imagen = null;
        try{
            byte[] imagen = new byte[file.getBytes().length];
            int i = 0;
            for (byte b : file.getBytes()){
                imagen[i++] = b;
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        List<Alquiler> alquiler = new ArrayList<Alquiler>();
        Cliente cliente= new Cliente(nombre, apellido, cedula, alquiler, null);
        clienteServicio.crearCliente(cliente);
        return "redirect:/clientes";
    }

    @RequestMapping(path = "/editar")
    public String editarCliente(Model model, @RequestParam(name = "id") long id,
                                @RequestParam(name = "nombre") String nombre,
                                   @RequestParam(name = "apellido") String apellido,
                                   @RequestParam(name = "cedula") String cedula,
                                   @RequestParam(name = "imagen") File file){
        Cliente clienteSearch = clienteServicio.getClienteById(id);
        Cliente cliente = new Cliente(nombre, apellido, cedula, clienteSearch.getAlquileres(), null);
        clienteServicio.editarCliente(cliente, id);
        return "redirect:/clientes";
    }

    @RequestMapping(path = "/eliminar/{id}")
    public String eliminarEstudiante(Model model, @PathVariable(name = "id") long id){
        clienteServicio.eliminarCliente(id);
        return "redirect:/clientes";
    }

}
