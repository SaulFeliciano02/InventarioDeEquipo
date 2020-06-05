package saulwebavanzada.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import saulwebavanzada.demo.services.FacturaServicio;

@Controller
@RequestMapping("/facturas")
public class FacturaControlador {
    @Autowired public FacturaServicio facturaServicio;

    @RequestMapping("")
    public String listarAlquileres(Model model){
        model.addAttribute("listaFacturas", facturaServicio.getFacturas());
        return "/thymeleaf/invoices.html";
    }
}
