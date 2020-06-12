package saulwebavanzada.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import saulwebavanzada.demo.entities.Familia;
import saulwebavanzada.demo.entities.SubFamilia;
import saulwebavanzada.demo.services.EquipoServicio;
import saulwebavanzada.demo.services.FamiliaServicio;
import saulwebavanzada.demo.services.SubFamiliaServicio;

@Controller
@RequestMapping("/familia")
public class FamiliaControlador {

    @Autowired public FamiliaServicio familiaServicio;
    @Autowired public SubFamiliaServicio subFamiliaServicio;
    @Autowired public EquipoServicio equipoServicio;

    @RequestMapping("")
    public String listarFamilias(Model model, @ModelAttribute("error") String error){
        model.addAttribute("listaFamilias", familiaServicio.getFamilias());
        model.addAttribute("listaSubFamilias", subFamiliaServicio.getSubFamilias());
        if(!error.equalsIgnoreCase("")){
            model.addAttribute("error", error);
        }
        return "/thymeleaf/familyAndSub";
    }

    @RequestMapping("/crearFamilia")
    public String crearFamilia(@RequestParam(name = "nombre") String nombre){
        Familia familia = new Familia(nombre);
        familiaServicio.crearFamilia(familia);
        return "redirect:/familia";
    }

    @RequestMapping("/editarFamilia")
    public String editarFamilia(@RequestParam(name = "id") long id, @RequestParam(name = "nombre") String nombre){
        Familia familia = new Familia(nombre);
        familiaServicio.editarFamilia(familia, id);
        return "redirect:/familia";
    }

    @RequestMapping("/eliminarFamilia/{id}")
    public RedirectView eliminarFamilia(@PathVariable(name = "id") long id, RedirectAttributes attributes){
        if(subFamiliaServicio.getSubFamiliaByFamilia(id).size() > 0){
            attributes.addFlashAttribute("error", "Familia relacionado a SubFamilia, no se puede eliminar.");
        }
        else{
            familiaServicio.eliminarFamilia(id);
        }
        return new RedirectView("/familia");
    }

    @RequestMapping("/crearSubFamilia")
    public String crearSubFamilia(@RequestParam(name = "nombre") String nombre,
                                  @RequestParam(name = "familia") String familiaInfo){
        Familia familia = familiaServicio.getFamiliaById(Long.parseLong(familiaInfo.split("-")[0]));
        SubFamilia subFamilia = new SubFamilia(nombre, familia);
        subFamiliaServicio.crearSubFamilia(subFamilia);
        return "redirect:/familia";
    }

    @RequestMapping("/editarSubFamilia")
    public String editarSubFamilia(@RequestParam(name = "id") long id, @RequestParam(name = "nombre") String nombre,
                                   @RequestParam(name = "familia") String familiaInfo){
        Familia familia = familiaServicio.getFamiliaById(Long.parseLong(familiaInfo.split("-")[0]));
        SubFamilia subFamilia = new SubFamilia(nombre, familia);
        subFamiliaServicio.editarSubFamilia(subFamilia, id);
        return "redirect:/familia";
    }

    @RequestMapping("/eliminarSubFamilia/{id}")
    public RedirectView eliminarSubFamilia(@PathVariable(name = "id") long id, RedirectAttributes attributes){
        SubFamilia subFamilia = subFamiliaServicio.getSubFamiliaById(id);
        if(equipoServicio.getEquipoBySubFamilia(subFamilia).size() > 0){
            attributes.addFlashAttribute("error", "Subfamilia relacionado a Equipo, no se puede eliminar.");
        }else{
            subFamiliaServicio.eliminarSubFamilia(id);
        }
        return new RedirectView("/familia");
    }
}
