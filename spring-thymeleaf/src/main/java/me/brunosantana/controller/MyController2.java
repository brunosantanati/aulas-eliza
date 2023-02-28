package me.brunosantana.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/geral")
public class MyController2 {

    //@RequestMapping(value = "/teste", method = RequestMethod.GET)
    @GetMapping("/teste")
    public String teste(){
        return "teste";
    }

    //@RequestMapping(value = "/teste2", method = RequestMethod.GET)
    @GetMapping("/teste2/{nome}")
    public String teste2(@PathVariable("nome") String nome){
        return "teste2 " + nome;
    }

}
