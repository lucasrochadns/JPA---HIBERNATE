package loja.entities.application;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import loja.entities.Categoria;
import loja.entities.Cliente;
import loja.entities.ItemPedido;
import loja.entities.Pedido;
import loja.entities.Produto;
import loja.model.dao.CategoriaDAO;
import loja.model.dao.ClienteDAO;
import loja.model.dao.DaoFactory;
import loja.model.dao.PedidoDAO;
import loja.model.dao.ProdutoDAO;

public class TesteLazerEager {
	public static void main(String[] args) {
		
	   /*LEMBRANDO DO CARREGAMENTO LAZY VOCÊ TOMAR EXCEPTION SE O ENTITY ESTIVER FECHADO
	    *  ANALISAR PEDIDODAO BUSCARPEDIDOCOMCLIENTE() -> JOIN FETCH NAQUELE MOMENTO ELE 
	    *  TRAZ O ENTIDADE CLIENTE EAGER
	    *  */
       popularBanco();
       EntityManager entity = DaoFactory.getEntityManager();
       PedidoDAO pedidoDAO = new PedidoDAO(entity);
       Pedido pedido = pedidoDAO.buscarPedidoComCliente(1);
       entity.close();
       System.out.println(pedido.getCliente().getDadosPessoais().getName());
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
