package com.example.demo.zexemplos;

public class CarroBuilder {
	
	private String placa;
	private String modelo;
	private String marca = "VW";
	
	public static CarroBuilder newBuilder() {
		return new CarroBuilder();
	}
	
	public CarroBuilder placa(String placa) {
		this.placa = placa;
		return this;
	}
	
	public CarroBuilder modelo(String modelo) {
		this.modelo = modelo;
		return this;
	}
	
	public CarroBuilder marca(String marca) {
		this.marca = marca;
		return this;
	}
	
	public Carro build() {
		return new Carro(placa, modelo, marca);
	}

}
