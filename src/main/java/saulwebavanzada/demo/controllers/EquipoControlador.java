package saulwebavanzada.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EquipoControlador {

    @RequestMapping(path = "/")
    public String login(){
        return "/thymeleaf/index";
    }

    @RequestMapping(path = "/home")
    public String home(){
        return "/thymeleaf/home";
    }

    @RequestMapping(path = "/usuarios")
    public String listarUsuarios(){
        return "/thymeleaf/users";
    }

    @RequestMapping(path = "/inventario")
    public String listarEquipos(){
        return "/thymeleaf/inventory";
    }

    @RequestMapping(path = "/clientes")
    public String listarClientes(){
        return "/thymeleaf/clients";
    }

    @RequestMapping(path = "/alquiler")
    public String listarAlquiler(){
        return "/thymeleaf/rental";
    }

    @RequestMapping(path = "/facturas")
    public String listarFacturas(){
        return "/thymeleaf/invoices";
    }
}
