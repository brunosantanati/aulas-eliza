package br.com.eliza.testespringwebeliza.repository;

import org.springframework.stereotype.Component;

import br.com.eliza.testespringwebeliza.model.Livro;

@Component
public class LivroRepository {
	
	public void salvar(Livro livro) {
		System.out.println("Livro salvo com sucesso! " + livro);
	}
	
	public void alterar(Long id, Livro livro) {
		System.out.println("Livro alterado com sucesso!" + livro);
	}
	
	public void deletar(Long id) {
		System.out.println("Livro deletado com sucesso! " + id);
	}
	
	public Livro consultar(Long id) {
		Livro livro = new Livro(1L, "Livro 1", "Autor 1");
		System.out.println("Retornando o livro: " + livro);
		return livro;
	}

}
