package me.brunosantana;

import org.junit.Assert;
import org.junit.Test;

public class ExecutorDeOperacoesMatematicasTest {

	@Test
	public void deveriaSomarDoisNumerosCorretamente() {
		double resultadoDaSoma = ExecutorDeOperacoesMatematicas.somar(50.0, 50.0);
		double resultadoEsperado = 100.0;
		
		Assert.assertEquals(resultadoEsperado, resultadoDaSoma, 0.01);
	}

}
