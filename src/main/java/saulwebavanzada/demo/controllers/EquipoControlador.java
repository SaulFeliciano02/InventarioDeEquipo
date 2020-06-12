package saulwebavanzada.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import saulwebavanzada.demo.entities.Equipo;
import saulwebavanzada.demo.entities.SubFamilia;
import saulwebavanzada.demo.entities.Usuario;
import saulwebavanzada.demo.services.EquipoServicio;
import saulwebavanzada.demo.services.SubFamiliaServicio;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/inventario")
public class EquipoControlador {
    @Autowired
    public EquipoServicio equipoServicio;

    @Autowired
    public SubFamiliaServicio subFamiliaServicio;

    @RequestMapping("")
    public String listarEquipos(Model model){
        model.addAttribute("listaSubFamilias", subFamiliaServicio.getSubFamilias());
        model.addAttribute("listaEquipos", equipoServicio.getEquipos());
        return "/thymeleaf/inventory.html";
    }

    @RequestMapping("/crear")
    public String crearEquipo(Model model, @RequestParam(name = "nombre") String nombre,
                               @RequestParam(name = "costoAlquiler") float costoAlquiler,
                               @RequestParam(name = "subFamilia") String subFamiliaNombre,
                               @RequestParam(name = "existencia") int existencia,
                               @RequestParam(name = "imagen") MultipartFile file) throws IOException {
        SubFamilia subFamilia = subFamiliaServicio.getSubFamiliaByNombre(subFamiliaNombre);
        String imagen = Base64.getEncoder().encodeToString(file.getBytes());
        Equipo equipo = new Equipo(nombre, costoAlquiler, subFamilia, imagen, file.getContentType(), existencia);
        equipoServicio.crearEquipo(equipo);
        return "redirect:/inventario";
    }

    @RequestMapping(path = "/editar")
    public String editarEquipo(@RequestParam(name = "nombre") String nombre,
                                @RequestParam(name = "costoAlquiler") float costoAlquiler,
                                @RequestParam(name = "subFamilia") String subFamiliaNombre,
                                @RequestParam(name = "existencia") int existencia,
                                @RequestParam(name = "imagen") MultipartFile file) throws IOException {
        SubFamilia subFamilia = subFamiliaServicio.getSubFamiliaByNombre(subFamiliaNombre);
        String imagen = Base64.getEncoder().encodeToString(file.getBytes());
        Equipo equipo = new Equipo(nombre, costoAlquiler, subFamilia, imagen, file.getContentType(), existencia);
        equipoServicio.editarEquipo(equipo);
         return "redirect:/inventario";
     }

    @RequestMapping(path = "/eliminar/{id}")
    public String eliminarEquipo(Model model, @PathVariable(name = "id") long id){
        equipoServicio.eliminarEquipo(id);
        return "redirect:/inventario";
    }

//    @RequestMapping(path = "/")
//    public String login(){
//        return "/thymeleaf/index";
//    }
//
//    @RequestMapping(path = "/home")
//    public String home(){
//        return "/thymeleaf/home";
//    }
//
//    @RequestMapping(path = "/usuarios")
//    public String listarUsuarios(){
//        return "/thymeleaf/users";
//    }
//
//    @RequestMapping(path = "/inventario")
//    public String listarEquipos(){
//        return "/thymeleaf/inventory";
//    }
//
//    @RequestMapping(path = "/clientes")
//    public String listarClientes(){
//        return "/thymeleaf/clients";
//    }
//
//    @RequestMapping(path = "/alquiler")
//    public String listarAlquiler(){
//        return "/thymeleaf/rental";
//    }
//
//    @RequestMapping(path = "/facturas")
//    public String listarFacturas(){
//        return "/thymeleaf/invoices";
//    }
//
//    @RequestMapping(path = "/familias")
//    public String listarFamilias(){
//        return "/thymeleaf/familyAndSub";
//    }
}
