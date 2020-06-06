package saulwebavanzada.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import saulwebavanzada.demo.entities.Alquiler;
import saulwebavanzada.demo.entities.Cliente;
import saulwebavanzada.demo.entities.Equipo;
import saulwebavanzada.demo.entities.Factura;
import saulwebavanzada.demo.services.AlquilerServicio;
import saulwebavanzada.demo.services.ClienteServicio;
import saulwebavanzada.demo.services.EquipoServicio;
import saulwebavanzada.demo.services.FacturaServicio;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/alquiler")
public class AlquilerControlador {
    @Autowired public AlquilerServicio alquilerServicio;
    @Autowired public ClienteServicio clienteServicio;
    @Autowired public FacturaServicio facturaServicio;
    @Autowired public EquipoServicio equipoServicio;

    @RequestMapping("")
    public String listarAlquileres(Model model){
        model.addAttribute("listaAlquileres", alquilerServicio.getAlquileres());
        model.addAttribute("listaClientes", clienteServicio.getClientes());
        model.addAttribute("listaEquipos", equipoServicio.getEquipos());
        return "/thymeleaf/rental.html";
    }

    @RequestMapping("/crear")
    public String crearAlquiler(@RequestParam(name = "equipo") String equipoInfo,
                                @RequestParam(name = "cantidad") int cantidad,
                                @RequestParam(name = "fechaPrometida") String fechaPrometidaInfo,
                                @RequestParam(name = "cliente") String clienteInfo) throws ParseException {
        Date fechaActual = new Date();
        Cliente cliente = clienteServicio.getClienteById(Long.parseLong(clienteInfo.split("-")[0]));
        Equipo equipo = equipoServicio.getEquipoById(Long.parseLong(equipoInfo.split("-")[0]));
        Date fechaPrometida = new SimpleDateFormat("dd/MM/yyyy").parse(fechaPrometidaInfo.split("-")[2] + "/" + fechaPrometidaInfo.split("-")[1] + "/" + fechaPrometidaInfo.split("-")[0]);
        for(int i = 0; i < cantidad; i++){
            Alquiler alquiler = new Alquiler(equipo, fechaActual, fechaPrometida, cliente);
            alquilerServicio.crearAlquiler(alquiler);
        }

        equipo.setExistencia(equipo.getExistencia()-cantidad);
        equipoServicio.editarEquipo(equipo);
        return "redirect:/alquiler";
    }

    @RequestMapping("/crearFactura")
    public String crearFactura(@RequestParam(name = "nombreCliente") String clienteInfo,
                               @RequestParam(name = "nombreAlquiler") String alquilerInfo,
                               @RequestParam(name = "nombreEquipo") String equipoInfo,
                               @RequestParam(name = "montoPagar") float montoPagar,
                               @RequestParam(name = "fechaAlquilado") Date fechaAlquilado,
                               @RequestParam(name = "fechaEntrega") Date fechaEntrega){
        Cliente cliente = clienteServicio.getClienteById(Long.parseLong(clienteInfo.split("-")[0]));
        Alquiler alquiler = alquilerServicio.getAlquilerById(Long.parseLong(alquilerInfo.split("-")[0]));
        Equipo equipo = alquiler.getEquipo();

        Factura factura = new Factura(equipo, alquiler, montoPagar);
        facturaServicio.crearFactura(factura);

        alquiler.setPagado(true);
        alquilerServicio.editarAlquiler(alquiler);
        return "redirect:/alquiler";
    }

    @RequestMapping(path = "/eliminar/{id}")
    public String eliminarAlquiler(Model model, @PathVariable(name = "id") long id){
        alquilerServicio.eliminarAlquiler(id);
        return "redirect:/equipos";
    }
}
