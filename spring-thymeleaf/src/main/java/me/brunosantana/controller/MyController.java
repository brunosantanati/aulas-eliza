package me.brunosantana.controller;

import me.brunosantana.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

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
        List<Produto> listaDeProdutos = List.of(
                new Produto("video-game", new BigDecimal("2500"), "https://picsum.photos/200/200?random=1"),
                new Produto("mesa", new BigDecimal("1000"), "https://picsum.photos/200/200?random=2"),
                new Produto("sofa", new BigDecimal("3000"), "https://picsum.photos/200/200?random=3"),
                new Produto("cadeira", new BigDecimal("200"), "https://picsum.photos/200/200?random=4"));

        model.addAttribute("listaDeProdutos", listaDeProdutos);

        return "produtos";
    }

    @GetMapping("/html-exemplos")
    public String html(Model model) {
        return "html-exemplos";
    }

}
