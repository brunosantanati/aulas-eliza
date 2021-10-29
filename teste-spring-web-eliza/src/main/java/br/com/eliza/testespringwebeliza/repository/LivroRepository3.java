package br.com.eliza.testespringwebeliza.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.eliza.testespringwebeliza.model.Livro;

@Repository
public interface LivroRepository3 extends CrudRepository<Livro, Long> {

}
