package loja.entities.application;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import loja.entities.Categoria;
import loja.entities.Cliente;
import loja.entities.ItemPedido;
import loja.entities.Pedido;
import loja.entities.Produto;
import loja.entities.RelatorioDeVendaVo;
import loja.model.dao.CategoriaDAO;
import loja.model.dao.ClienteDAO;
import loja.model.dao.DaoFactory;
import loja.model.dao.PedidoDAO;
import loja.model.dao.ProdutoDAO;

public class CadastratoPedido {
    
	public static void main(String[] args) {
	    	popularBanco();
	    	EntityManager manager = DaoFactory.getEntityManager();
	    	
	    	
	    	PedidoDAO pedidoDAO = new PedidoDAO(manager);
	    	
	    	
	   
	    	
            Pedido pedidoD = pedidoDAO.findById(1);
            pedidoD.getItens().stream().forEach(System.out::println);
            BigDecimal totalV = pedidoDAO.valorTotalVendido();
	    	System.out.println(pedidoD);
	    	System.out.println("\n\n\ntotal " + totalV);
	    	List<RelatorioDeVendaVo> relatorio = pedidoDAO.relatorioDeVendas();
	    	relatorio.stream().forEach(System.out::println);
	}
	public static void popularBanco() {
		EntityManager entity = DaoFactory.getEntityManager();
		
		Categoria celular = new Categoria(null,"Celulares");
		Categoria videoGame = new Categoria(null,"Gammer");
		Categoria hardware = new Categoria(null,"HardWare");
		
		Produto iphone = new Produto(null,"IPHONE 14 PRO MAX", "APPLE M8 256GB", new BigDecimal("9500.00"), LocalDate.now(), celular);
		Produto playStation = new Produto(null,"Playstation 5", "1024GB SSD", new BigDecimal("4500.00"), LocalDate.now(), videoGame);
		Produto macbook = new Produto(null,"MACBOOK PRO", "M8 256GB SSD ", new BigDecimal("8500.00"), LocalDate.now(), hardware);
		
		Cliente clienteLucas = new Cliente(null, "LUCAS ROCHA DOS SANTOS", "12345678952");
		Cliente clienteAnna = new Cliente(null, "ANNA CLARA BERNARDINO ROCHA", "789456123");
		
		Pedido pedidoUm = new Pedido(null, iphone.getData() , clienteAnna);
		pedidoUm.adicionarItem(new ItemPedido(null, 1, pedidoUm, iphone));
		pedidoUm.adicionarItem(new ItemPedido(null, 1, pedidoUm, macbook));
		
		Pedido pedidoDois = new Pedido(null, iphone.getData() , clienteAnna);
		pedidoDois.adicionarItem(new ItemPedido(null, 2, pedidoDois, iphone));
		pedidoDois.adicionarItem(new ItemPedido(null, 1, pedidoDois, playStation));
		pedidoDois.adicionarItem(new ItemPedido(null, 2, pedidoDois, macbook));
		
		
		ClienteDAO clienteDAO = new ClienteDAO(entity);
    	PedidoDAO pedidoDAO = new PedidoDAO(entity);
		CategoriaDAO catDAO = new CategoriaDAO(entity);
		ProdutoDAO produtoDAO = new ProdutoDAO(entity);
		
		entity.getTransaction().begin();
		
		catDAO.salvar(celular);
		catDAO.salvar(hardware);
		catDAO.salvar(videoGame);
		
		produtoDAO.salvar(iphone);
		produtoDAO.salvar(playStation);
		produtoDAO.salvar(macbook);
		
		clienteDAO.salvar(clienteAnna);
		clienteDAO.salvar(clienteLucas);
		
		pedidoDAO.salvar(pedidoUm);
		pedidoDAO.salvar(pedidoDois);
		
		entity.getTransaction().commit();
		entity.close();
		
	}
}
