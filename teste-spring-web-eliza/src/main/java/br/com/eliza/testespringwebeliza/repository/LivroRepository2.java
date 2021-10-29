package br.com.eliza.testespringwebeliza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eliza.testespringwebeliza.model.Livro;

@Repository
public interface LivroRepository2 extends JpaRepository<Livro, Long> {
	
	public List<Livro> findByAutor(String autor);

}
