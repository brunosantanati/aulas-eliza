package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Serie;

public class SerieDao {
	
	private EntityManager em;

	public SerieDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Serie serie) {
		this.em.persist(serie);
	}
	
	public void atualizar(Serie serie) {
		this.em.merge(serie);
	}
	
	public void remover(Serie serie) {
		serie = em.merge(serie);
		this.em.remove(serie);
	}
	
	public Serie buscarPorId(Long id) {
		return em.find(Serie.class, id);
	}

}
