package me.brunosantana.alexa;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.Assert;

public class CasaAutomatizadaTest {

	@Test
	public void test() {
		//Alexa alexa = new Alexa();
		Alexa alexa = mock(Alexa.class);
		when(alexa.perguntar(anyString())).thenReturn("Estou bem");
		
		CasaAutomatizada casa = new CasaAutomatizada(alexa);
		String resposta = casa.perguntarParaAlexa("Como vai você?");
		
		//System.out.println(resposta);
		
		Assert.assertEquals("Estou bem", resposta);
	}

}
