package com.example.demo.zexemplos;

public class Principal {

	public static void main(String[] args) {
		
		Carro carro = CarroBuilder.newBuilder()
				.placa("XPTO256325")
				.modelo("Fusca")
				.build();
		
		System.out.println(carro);
	}
	
}
