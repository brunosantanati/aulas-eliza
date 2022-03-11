package me.brunosantana;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ExecutorDeOperacoesMatematicasTest {

	@Test
	public void deveriaSomarDoisNumerosCorretamente() {
		double resultadoDaSoma = new ExecutorDeOperacoesMatematicas().somar(50.0, 50.0);
		double resultadoEsperado = 100.0;
		
		Assert.assertEquals(resultadoEsperado, resultadoDaSoma, 0.01);
	}
	
	@Test
	public void deveriaSomarDoisNumerosAleatoriosCorretamente() {
		//GeradorDeNumerosAleatorios gerador = new GeradorDeNumerosAleatorios();
		GeradorDeNumerosAleatorios gerador = mock(GeradorDeNumerosAleatorios.class);
		when(gerador.gerarNumero(anyDouble(), anyDouble())).thenReturn(5.0);
		
		double resultadoDaSoma = new ExecutorDeOperacoesMatematicas(gerador).somarNumerosAleatorios(1.0, 10.0);

		double resultadoEsperado = 10.0;
		
		Assert.assertEquals(resultadoEsperado, resultadoDaSoma, 0.01);
	}

}
