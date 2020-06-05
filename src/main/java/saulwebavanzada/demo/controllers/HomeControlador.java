package saulwebavanzada.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControlador {
    @RequestMapping("/home")
    public String home(){
        return "/thymeleaf/home";
    }

    @RequestMapping("/familia")
    public String familia(){
        return "/thymeleaf/familyAndSub";
    }
}
