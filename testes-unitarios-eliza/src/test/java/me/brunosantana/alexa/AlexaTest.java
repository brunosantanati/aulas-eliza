package me.brunosantana.alexa;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AlexaTest {

	@Test
	public void deveriaResponderCorretamenteQuandoFazUmaPergunta() {
		Alexa alexa = new Alexa();
		String resposta = alexa.perguntar("Como vai voc�?");
		System.out.println(resposta);
		
		Assert.assertTrue(List.of("Vou muito bem, obrigado", "Estou bem e voc�?", "Vou bem nas alturas").contains(resposta));
	}

}
