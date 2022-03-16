package me.brunosantana.matematica;

public class GeradorDeNumerosAleatorios {
	
	public double gerarNumero(double min, double max) {
		return (double) Math.floor(Math.random() * (max - min + 1) + min);
	}

}
