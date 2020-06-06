package saulwebavanzada.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import saulwebavanzada.demo.entities.Familia;
import saulwebavanzada.demo.entities.SubFamilia;
import saulwebavanzada.demo.services.FamiliaServicio;
import saulwebavanzada.demo.services.SubFamiliaServicio;

@Controller
@RequestMapping("/familia")
public class FamiliaControlador {

    @Autowired public FamiliaServicio familiaServicio;
    @Autowired public SubFamiliaServicio subFamiliaServicio;

    @RequestMapping("")
    public String listarFamilias(Model model){
        model.addAttribute("listaFamilias", familiaServicio.getFamilias());
        model.addAttribute("listaSubFamilias", subFamiliaServicio.getSubFamilias());
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
    public String eliminarFamilia(@PathVariable(name = "id") long id){
        familiaServicio.eliminarFamilia(id);
        return "redirect:/familia";
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
    public String eliminarSubFamilia(@PathVariable(name = "id") long id){
        subFamiliaServicio.eliminarSubFamilia(id);
        return "redirect:/familia";
    }
}
