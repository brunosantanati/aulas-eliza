package br.com.eliza.testespringwebeliza.repository;

import org.springframework.data.repository.Repository;

import br.com.eliza.testespringwebeliza.model.Livro;

public interface LivroRepository4 extends Repository<Livro, Long> {
	
	Livro save(Livro livro);

}
