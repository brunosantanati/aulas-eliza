package br.com.alura.loja.testes;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.AlunoDao;
import br.com.alura.loja.dao.MateriaDao;
import br.com.alura.loja.dao.SerieDao;
import br.com.alura.loja.modelo.Aluno;
import br.com.alura.loja.modelo.Materia;
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
		Optional<Serie> serieOptional = aluno.getSeries().stream().filter(s -> s.getNome().equals(aluno.getSerieAtual())).findFirst();
		if(serieOptional.isPresent()) {
			Serie serieAtual = serieOptional.get();
			System.out.println(serieAtual.getId());
			System.out.println(serieAtual.getNome());
			System.out.println("\n######## Materias da Serie Atual ###########");
			serieAtual.getMaterias().forEach(System.out::println);
		}
		
		System.out.println("\n######## Pegar serie ###########");
		
		SerieDao serieDao = new SerieDao(em);
		Serie serie = serieDao.buscarPorId(4L);
		System.out.println(serie);
		serie.getAlunos().forEach(System.out::println);
		
		em.close();
	}

	private static void cadastrarAluno() {
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		//Cadastrar matérias
		
		Materia portugues = new Materia("Portugues");		
		Materia matematica = new Materia("Matematica");		
		Materia historia = new Materia("Historia");		
		Materia geografia = new Materia("Geografia");
		
		MateriaDao materiaDao = new MateriaDao(em);
		
		materiaDao.cadastrar(portugues);
		materiaDao.cadastrar(matematica);
		materiaDao.cadastrar(historia);
		materiaDao.cadastrar(geografia);
		
		//Cadastrar series
		
		List<Materia> todasMaterias = List.of(portugues, matematica, historia, geografia);
		
		Serie primeiroAnoA = new Serie("1A");
		primeiroAnoA.setMaterias(todasMaterias);
		
		Serie segundoAnoA = new Serie("2A");
		segundoAnoA.setMaterias(todasMaterias);
		
		Serie primeiroAnoB = new Serie("1B");
		primeiroAnoB.setMaterias(todasMaterias);
		
		Serie segundoAnoB = new Serie("2B");
		segundoAnoB.setMaterias(todasMaterias);
		
		SerieDao serieDao = new SerieDao(em);
		
		serieDao.cadastrar(primeiroAnoA);
		serieDao.cadastrar(segundoAnoA);
		serieDao.cadastrar(primeiroAnoB);
		serieDao.cadastrar(segundoAnoB);
		
		//Cadastrar alunos
		
		Aluno marcos = new Aluno("Marcos", "2A");
		marcos.setSeries(List.of(primeiroAnoA, segundoAnoA));
		
		Aluno lucas = new Aluno("Lucas", "2B");
		lucas.setSeries(List.of(segundoAnoB));
		
		AlunoDao alunoDao = new AlunoDao(em);
		
		alunoDao.cadastrar(marcos);
		alunoDao.cadastrar(lucas);
		
		em.getTransaction().commit();
		em.close();
	}

}
