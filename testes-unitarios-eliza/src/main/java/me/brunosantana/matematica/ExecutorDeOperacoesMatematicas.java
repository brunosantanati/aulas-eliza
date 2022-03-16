package me.brunosantana.matematica;

public class ExecutorDeOperacoesMatematicas {
	
	GeradorDeNumerosAleatorios gerador;
	
	public ExecutorDeOperacoesMatematicas() {
	}
	
	public ExecutorDeOperacoesMatematicas(GeradorDeNumerosAleatorios gerador) {
		this.gerador = gerador;
	}

	public double somar(double numero1, double numero2) {
		return numero1 + numero2;
	}
	
	public double somarNumerosAleatorios(double min, double max) {
		return gerador.gerarNumero(min, max) + gerador.gerarNumero(min, max);
	}
	
}
