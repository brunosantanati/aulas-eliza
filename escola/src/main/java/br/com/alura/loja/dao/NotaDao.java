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
	
	public Nota buscarPorIdComposto(long idAluno, long idSerie, long idMateria) {
		String jpql = "SELECT n FROM Nota n WHERE n.aluno.id = :idAluno AND n.serie.id = :idSerie AND n.materia.id = :idMateria";
		return em.createQuery(jpql, Nota.class)
				.setParameter("idAluno", idAluno)
				.setParameter("idSerie", idSerie)
				.setParameter("idMateria", idMateria)
				.getSingleResult();
	}

}
