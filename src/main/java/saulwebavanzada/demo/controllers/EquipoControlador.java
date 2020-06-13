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
import saulwebavanzada.demo.entities.Equipo;
import saulwebavanzada.demo.entities.Familia;
import saulwebavanzada.demo.entities.SubFamilia;
import saulwebavanzada.demo.entities.Usuario;
import saulwebavanzada.demo.repositories.AlquilerRepositorio;
import saulwebavanzada.demo.services.AlquilerServicio;
import saulwebavanzada.demo.services.EquipoServicio;
import saulwebavanzada.demo.services.FamiliaServicio;
import saulwebavanzada.demo.services.SubFamiliaServicio;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/inventario")
public class EquipoControlador {
    @Autowired public EquipoServicio equipoServicio;
    @Autowired public SubFamiliaServicio subFamiliaServicio;
    @Autowired public AlquilerServicio alquilerServicio;
    @Autowired public FamiliaServicio familiaServicio;

    @RequestMapping("")
    public String listarEquipos(Model model, @ModelAttribute("error") String error){
        model.addAttribute("listaSubFamilias", subFamiliaServicio.getSubFamilias());
        model.addAttribute("listaEquipos", equipoServicio.getEquipos());
        model.addAttribute("listaFamilias", familiaServicio.getFamilias());
        if(!error.equalsIgnoreCase("")){
            model.addAttribute("error", error);
        }
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
    public RedirectView eliminarEquipo(Model model, @PathVariable(name = "id") long id, RedirectAttributes attributes){
        Equipo equipo = equipoServicio.getEquipoById(id);
        if(alquilerServicio.getAlquilerByEquipo(equipo).size() > 0){
            attributes.addFlashAttribute("error", "Equipo relacionado a Alquiler, no se puede eliminar.");
        }
        equipoServicio.eliminarEquipo(id);
        return new RedirectView("/inventario");
    }

    @RequestMapping(path = "/crearFamilia")
    public String crearFamilia(@RequestParam(name = "nombre") String nombre){
        Familia familia = new Familia(nombre);
        familiaServicio.crearFamilia(familia);
        return "redirect:/inventario";
    }

    @RequestMapping(path = "/crearSubFamilia")
    public String crearSubFamilia(@RequestParam(name = "nombre") String nombre,
                                  @RequestParam(name = "familia") String familiaInfo){
        Familia familia = familiaServicio.getFamiliaById(Long.parseLong(familiaInfo.split("-")[0]));
        SubFamilia subFamilia = new SubFamilia(nombre, familia);
        subFamiliaServicio.crearSubFamilia(subFamilia);
        return "redirect:/inventario";
    }
}
