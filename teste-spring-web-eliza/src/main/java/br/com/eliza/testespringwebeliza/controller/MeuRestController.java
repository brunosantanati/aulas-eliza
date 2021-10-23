package br.com.eliza.testespringwebeliza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.eliza.testespringwebeliza.model.Livro;
import br.com.eliza.testespringwebeliza.model.Mensagem;
import br.com.eliza.testespringwebeliza.repository.LivroRepository;
import br.com.eliza.testespringwebeliza.repository.LivroRepository2;

@RestController
public class MeuRestController {
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	LivroRepository2 livroRepository2;

	@GetMapping("/livros/{id}")
	public Livro consultar(@PathVariable Long id) {
		return livroRepository.consultar(id);
	}
	
	@PostMapping("/livros")
	public Mensagem salvar(@RequestBody Livro livro) {
		//livroRepository.salvar(livro);
		livroRepository2.save(livro);
		return new Mensagem("request.success", "Livro salvo com sucesso!");
	}
	
	@PutMapping("/livros/{id}")
	public Mensagem alterar(@RequestBody Livro livro, @PathVariable Long id) {
		livroRepository.alterar(id, livro);
		return new Mensagem("request.success", "Livro alterado com sucesso!");
	}
	
	@DeleteMapping("/livros/{id}")
	public Mensagem deletar(@PathVariable Long id) {
		livroRepository.deletar(id);
		return new Mensagem("request.success", "Livro deletado com sucesso!");
	}
	
}
