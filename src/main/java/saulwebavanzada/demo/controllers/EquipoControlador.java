package saulwebavanzada.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EquipoControlador {

    @RequestMapping(path = "/")
    public String listarEstudiantes(){
        return "/thymeleaf/index";
    }

}
