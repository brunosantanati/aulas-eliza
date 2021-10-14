package br.com.eliza.testespringwebeliza.model;

public class Bolacha {
	
	private String sabor;
	private double preco;
	
	public Bolacha(String sabor, double preco) {
		super();
		this.sabor = sabor;
		this.preco = preco;
	}
	
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
