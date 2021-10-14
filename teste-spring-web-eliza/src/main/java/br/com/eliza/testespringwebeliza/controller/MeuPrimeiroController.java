package br.com.eliza.testespringwebeliza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eliza.testespringwebeliza.model.Bolacha;
import br.com.eliza.testespringwebeliza.service.MeuPrimeiroService;

@RestController
public class MeuPrimeiroController {
	
	@Autowired
	MeuPrimeiroService meuPrimeiroService;

	@GetMapping("/meu-endpoint")
	public Bolacha meuMetodo() {
		//processamento
		return new Bolacha("morango", 5.0);
	}
	
	@GetMapping("/somar")
	public double somar(@RequestParam double n1, @RequestParam double n2) {
		return meuPrimeiroService.somar(n1, n2);
	}
	
	@GetMapping("/somar2/{n1}/{n2}")
	public double somar2(@PathVariable double n1, @PathVariable double n2) {
		return meuPrimeiroService.somar(n1, n2);
	}
	
}
