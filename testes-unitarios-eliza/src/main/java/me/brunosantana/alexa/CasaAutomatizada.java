package me.brunosantana.alexa;

public class CasaAutomatizada {
	
	private Alexa alexa;
	
	public CasaAutomatizada(Alexa alexa) {
		this.alexa = alexa;
	}

	public Alexa getAlexa() {
		return alexa;
	}

	public void setAlexa(Alexa alexa) {
		this.alexa = alexa;
	}
	
	public String perguntarParaAlexa(String pergunta) {
		return alexa.perguntar(pergunta);
	}

}
