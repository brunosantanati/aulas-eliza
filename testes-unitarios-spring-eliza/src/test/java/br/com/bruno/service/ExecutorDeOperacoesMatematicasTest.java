package br.com.bruno.service;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	}

}
