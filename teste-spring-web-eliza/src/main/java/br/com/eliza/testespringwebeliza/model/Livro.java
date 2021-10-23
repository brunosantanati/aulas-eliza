package br.com.eliza.testespringwebeliza.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String autor;
	
	@Deprecated
	public Livro() {
		//somente para o Hibernate
	}
	
	public Livro(Long id, String nome, String autor) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", nome=" + nome + ", autor=" + autor + "]";
	}
	
}
