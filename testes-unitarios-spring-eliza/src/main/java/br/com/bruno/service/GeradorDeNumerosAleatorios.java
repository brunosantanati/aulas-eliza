package br.com.bruno.service;

import org.springframework.stereotype.Service;

@Service
public class GeradorDeNumerosAleatorios {
	
	public double gerarNumero(double min, double max) {
		if(max > 1000) throw new IllegalArgumentException("Numero nao pode ser maior que 1000");
		return (double) Math.floor(Math.random() * (max - min + 1) + min);
	}

}
