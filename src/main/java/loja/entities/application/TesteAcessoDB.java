package loja.entities.application;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import loja.entities.Categoria;
import loja.entities.Produto;
import loja.model.dao.CategoriaDAO;
import loja.model.dao.DaoFactory;
import loja.model.dao.ProdutoDAO;

public class TesteAcessoDB {
	public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = DaoFactory.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		System.out.println(produtoDAO.findById(1));
		List<Produto> lista = produtoDAO.findAll();
		System.out.println(
				"\n\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++ // +++++++++++++++++++++++++++++++++++++++++++");
		lista.stream().forEach(System.out::println);
		System.out.println(
				"\n\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++ // +++++++++++++++++++++++++++++++++++++++++++");
		List<Produto> lista2 = produtoDAO.findName("IPHONE X12");
		System.out.println(
				"\n\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++ // +++++++++++++++++++++++++++++++++++++++++++");
		lista2.stream().forEach(System.out::println);
		System.out.println(
				"\n\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++ // +++++++++++++++++++++++++++++++++++++++++++");
		List<Produto> lista3 = produtoDAO.findCategoria("Celular");
		lista3.stream().forEach(System.out::println);

		System.out.println(
				"\n\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++ // +++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(produtoDAO.buscaPrecoDoProdutoComNome("IPHONE X12 PRO MAX"));
	}

	public static void cadastrarProduto() {
		EntityManager em2 = DaoFactory.getEntityManager();
		Categoria categoria = new Categoria(null, "Celular");
		Produto produto = new Produto(null, "IPHONE X11", "64GB 8GB RAM", new BigDecimal("3000.00"), LocalDate.now(),
				categoria);
		Produto produto2 = new Produto(null, "IPHONE X12", "64GB 8GB RAM", new BigDecimal("4000.00"), LocalDate.now(),
				categoria);
		Produto produto3 = new Produto(null, "IPHONE X12 PRO", "128GB 8GB RAM", new BigDecimal("5500.00"),
				LocalDate.now(), categoria);
		Produto produto4 = new Produto(null, "IPHONE X12 PRO MAX", "256GB 8GB RAM", new BigDecimal("6500.00"),
				LocalDate.now(), categoria);
		Produto produto5 = new Produto(null, "IPHONE X11", "64GB 8GB RAM", new BigDecimal("3000.00"), LocalDate.now(),
				categoria);

		CategoriaDAO catDAO = new CategoriaDAO(em2);
		ProdutoDAO produtoDAO = new ProdutoDAO(em2);
		
	    em2.getTransaction().begin();
		catDAO.salvar(categoria);
		produtoDAO.salvar(produto);
		produtoDAO.salvar(produto2);
		produtoDAO.salvar(produto3);
		produtoDAO.salvar(produto4);
		produtoDAO.salvar(produto5);

        em2.getTransaction().commit();
        em2.close();
	}
}
