package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Materia;

public class MateriaDao {
	
	private EntityManager em;

	public MateriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Materia materia) {
		this.em.persist(materia);
	}
	
	public void atualizar(Materia materia) {
		this.em.merge(materia);
	}
	
	public void remover(Materia materia) {
		materia = em.merge(materia);
		this.em.remove(materia);
	}
	
	public Materia buscarPorId(Long id) {
		return em.find(Materia.class, id);
	}

}
