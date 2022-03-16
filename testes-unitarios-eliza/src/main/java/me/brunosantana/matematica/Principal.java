package me.brunosantana.matematica;

public class Principal {
	
	public static void main(String[] args) {
		System.out.println(new ExecutorDeOperacoesMatematicas().somar(50.0, 50.0));
		
		GeradorDeNumerosAleatorios gerador = new GeradorDeNumerosAleatorios();
		System.out.println(new ExecutorDeOperacoesMatematicas(gerador).somarNumerosAleatorios(1.0, 2.0));
	}

}
