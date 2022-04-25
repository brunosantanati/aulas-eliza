package br.com.bruno.service;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ExecutorDeOperacoesMatematicasTest {
	
	@InjectMocks
	ExecutorDeOperacoesMatematicas executor;
	
	@Mock
	GeradorDeNumerosAleatorios gerador;
	
	@Test
	public void deveriaSomarDoisNumerosAleatoriosCorretamente() {
		
		when(gerador.gerarNumero(anyDouble(), anyDouble())).thenReturn(5.0);
		
		double resultadoDaSoma = executor.somarNumerosAleatorios(1.0, 10.0);

		double resultadoEsperado = 10.0;
		
		Assert.assertEquals(resultadoEsperado, resultadoDaSoma, 0.01);
		verify(gerador, times(2)).gerarNumero(anyDouble(), anyDouble());
	}
	
	@Test
	public void deveriaImprimirONumeroMaiorCorretamente() {
		Matematica matematica = Mockito.mock(Matematica.class);
		when(matematica.max(anyInt(), anyInt())).thenReturn(6);
		
		executor.imprimirMaior(matematica, 2, 6);
		
		verify(matematica, times(1)).max(anyInt(), anyInt());
	}

}
