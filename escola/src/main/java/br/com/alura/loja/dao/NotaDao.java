package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Nota;

public class NotaDao {
	
	private EntityManager em;

	public NotaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Nota nota) {
		this.em.persist(nota);
	}
	
	public void atualizar(Nota nota) {
		this.em.merge(nota);
	}
	
	public void remover(Nota nota) {
		nota = em.merge(nota);
		this.em.remove(nota);
	}
	
	public Nota buscarPorId(Long id) {
		return em.find(Nota.class, id);
	}

}
