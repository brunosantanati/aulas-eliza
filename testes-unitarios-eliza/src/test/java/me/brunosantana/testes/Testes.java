package me.brunosantana.testes;

import org.junit.Assert;
import org.junit.Test;

public class Testes {
	
	@Test
	public void testarDelta() {
		double numero1 = 10.0;
		double numero2 = numero1 - 0.01;
		
		System.out.println(numero1);
		System.out.println(numero2);
		
		//Assert.assertEquals(numero1, numero2);
		Assert.assertEquals(numero1, numero2, 0.01);
	}

}
