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
	
	@Test(expected=IllegalArgumentException.class)
	public void deveriaLancarIllegalArgumentExceptionQuandoMaxEhMaiorQue1000() {
		
		doThrow(new IllegalArgumentException("Numero nao pode ser maior que 1000")).when(gerador).gerarNumero(anyDouble(), anyDouble());
		
		executor.somarNumerosAleatorios(1.0, 1001.0);

		verify(gerador, times(1)).gerarNumero(anyDouble(), anyDouble());
	}
	
	@Test(expected=ArithmeticException.class)
	public void deveriaLancarArithmeticException() {
		executor.dividir(10, 0);
	}
	
	@Test
	public void deveriaImprimirONumeroMaiorCorretamente() {
		Matematica matematica = Mockito.mock(Matematica.class);
		when(matematica.max(anyInt(), anyInt())).thenReturn(6);
		
		executor.imprimirMaior(matematica, 2, 6);
		
		verify(matematica, times(1)).max(anyInt(), anyInt());
	}

}
