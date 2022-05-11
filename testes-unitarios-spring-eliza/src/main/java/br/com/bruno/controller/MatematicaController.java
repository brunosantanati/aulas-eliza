package br.com.bruno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.dto.ResultadoDaSoma;
import br.com.bruno.service.BibliaService;
import br.com.bruno.service.ExecutorDeOperacoesMatematicas;

@RestController
public class MatematicaController {
	
	@Autowired
	ExecutorDeOperacoesMatematicas executor;
	
	@Autowired
	BibliaService bibliaService;
	
	@GetMapping("somar/{numero1}/{numero2}")
	public ResponseEntity<ResultadoDaSoma> somar(@PathVariable double numero1, @PathVariable double numero2){
		double resultado = executor.somar(numero1, numero2);
		return ResponseEntity.ok(new ResultadoDaSoma(resultado));
	}
	
	@GetMapping("somar")
	public ResponseEntity<ResultadoDaSoma> somar(){
		double resultado = executor.somarNumerosAleatorios(1, 3);
		return ResponseEntity.ok(new ResultadoDaSoma(resultado));
	}
	
	@GetMapping("biblia")
	public ResponseEntity<String> biblia(){
		String url = bibliaService.getUrl();
		return ResponseEntity.ok(url);
	}

}
