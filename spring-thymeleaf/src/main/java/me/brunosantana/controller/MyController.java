package me.brunosantana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("nome", "Mundo!");
        model.addAttribute("status", "ENTREGUE");
        return "hello";
    }

    @GetMapping("/produtos")
    public String produtos(Model model) {
        return "produtos";
    }

}
