package me.brunosantana.alexa;

import me.brunosantana.matematica.GeradorDeNumerosAleatorios;

public class Alexa {

	public String perguntar(String pergunta) {
		if(pergunta.equals("Como vai você?")) {
			String[] respostas = new String[3];
			respostas[0] = "Vou muito bem, obrigado";
			respostas[1] = "Estou bem e você?";
			respostas[2] = "Vou bem nas alturas";
			return respostas[(int) new GeradorDeNumerosAleatorios().gerarNumero(0, 2)];
		}else {
			return "Não conheço essa";
		}
	}
	
}
