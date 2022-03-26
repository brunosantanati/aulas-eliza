package br.com.bruno.service;

import org.springframework.stereotype.Service;

@Service
public class GeradorDeNumerosAleatorios {
	
	public double gerarNumero(double min, double max) {
		return (double) Math.floor(Math.random() * (max - min + 1) + min);
	}

}
