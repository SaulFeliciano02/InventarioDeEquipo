package saulwebavanzada.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class loginControlador {

    @RequestMapping(path = "")
    public String redirectologin()
    {
        return "redirect:login";
    }

    @RequestMapping(path = "/login")
    public String login(){
        return "/thymeleaf/index";
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
//        return new ModelAndView("login", "error", error);
//    }

}
