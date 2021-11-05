package br.com.eliza.testespringwebeliza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.eliza.testespringwebeliza.model.Livro;

@Repository
public interface LivroRepository2 extends JpaRepository<Livro, Long> {
	
	public List<Livro> findByAutor(String autor);
	
	@Query("select l from Livro l")
	public List<Livro> findAllLivros();
	
	@Query("select l from Livro l where l.nome like %:nome%")
	public List<Livro> findByNomeDoLivro(@Param("nome") String nome);
	
	//TODO: criar um novo método que usa @Query que busca um livro por id
	//TODO: criar um novo método chamado findByNome(sem @Query) para buscar um livro por nome
	//TODO: criar dois endpoints no MeuRestController para testar as duas queries

}
