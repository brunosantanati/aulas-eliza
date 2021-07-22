package br.com.alura.loja.testes;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.AlunoDao;
import br.com.alura.loja.dao.SerieDao;
import br.com.alura.loja.modelo.Aluno;
import br.com.alura.loja.modelo.Serie;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeAluno {
	
	public static void main(String[] args) {
		cadastrarAluno();
		
		EntityManager em = JPAUtil.getEntityManager();
		
		System.out.println("\n######## Pegar aluno ###########");
		
		AlunoDao alunoDao = new AlunoDao(em);		
		Aluno aluno = alunoDao.buscarPorId(1l);
		
		System.out.println(aluno);
		
		aluno.getSeries().forEach(s -> System.out.println(s));
		
		System.out.println("\n######## Serie Atual ###########");
		Optional<Serie> serieOptional = aluno.getSeries().stream().filter(s -> s.isAtual()).findFirst();
		if(serieOptional.isPresent()) {
			System.out.println(serieOptional.get());;
		}
		
		System.out.println("\n######## Pegar serie ###########");
		
		SerieDao serieDao = new SerieDao(em);
		Serie serie = serieDao.buscarPorId(2L);
		serie.getAlunos().forEach(System.out::println);
		
		em.close();
	}

	private static void cadastrarAluno() {
		
		Aluno aluno = new Aluno("Marcos");
		Aluno aluno2 = new Aluno("Lucas");
		
		Serie primeiroAno = new Serie("1B", false);
		Serie segundoAno = new Serie("2B", true);
		
		List<Serie> series = List.of(primeiroAno, segundoAno);
		aluno.setSeries(series);
		List<Serie> series2 = List.of(segundoAno);
		aluno2.setSeries(series2);
		
		EntityManager em = JPAUtil.getEntityManager();
		AlunoDao alunoDao = new AlunoDao(em);
		
		em.getTransaction().begin();
		
		alunoDao.cadastrar(aluno);
		alunoDao.cadastrar(aluno2);
		
		em.getTransaction().commit();
		em.close();
	}

}
