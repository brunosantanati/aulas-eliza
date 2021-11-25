package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PrevisaoDoTempo;
import com.example.demo.service.PrevisaoDoTempoService;

@RestController
public class PrevisaoDoTempoController {
	
	@Autowired
	PrevisaoDoTempoService previsaoDoTempoService;
	
	@GetMapping(value = "/previsao", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrevisaoDoTempo> getPrevisao(@RequestParam String endereco){
		PrevisaoDoTempo previsaoDoTempo = previsaoDoTempoService.getPrevisaoDoTempo(endereco);
		return new ResponseEntity<>(previsaoDoTempo, HttpStatus.OK);
	}

}
