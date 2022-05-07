package br.com.bruno.service;

import org.springframework.stereotype.Service;

@Service
public class GeradorDeNumerosAleatorios {
	
	public double gerarNumero(double min, double max) {
		if(min > 1000 || max > 1000) throw new IllegalArgumentException("Numero nao pode ser maior que 1000");
		return (double) Math.floor(Math.random() * (max - min + 1) + min);
	}

}
