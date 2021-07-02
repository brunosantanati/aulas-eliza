package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

// Código do curso: https://cursos.alura.com.br/course/persistencia-jpa-introducao-hibernate/

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		todos.forEach(p2 -> System.out.println(p.getNome()));
	
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
		System.out.println("Preco do Produto: " +precoDoProduto);
		
		testando();
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}
	
	private static void testando() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		Categoria celulares = categoriaDao.buscarPorId(1L);
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto celular = new Produto("Galaxy S10", "Muito legal", new BigDecimal("2000"), celulares);
		
		em.getTransaction().begin();
		
		produtoDao.cadastrar(celular);
		
		//celular.setDescricao("Muito caro"); //isso faz alterar o produto porque ele está managed
		
		em.getTransaction().commit();
		em.close();
		
		//######################################
		
		em = JPAUtil.getEntityManager();
		produtoDao = new ProdutoDao(em);
		em.getTransaction().begin();
		
		celular.setDescricao("Muito caro");
		produtoDao.atualizar(celular); //aqui como o objeto está detached, usamos o merge (o atualizar chama o merge)
		
		em.getTransaction().commit();
		em.close();
		
	}

}
