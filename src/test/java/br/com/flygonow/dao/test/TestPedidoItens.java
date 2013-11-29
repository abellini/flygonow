package br.com.flygonow.dao.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.flygonow.dao.AtendenteDao;
import br.com.flygonow.dao.ItensPedidoDao;
import br.com.flygonow.dao.OrderDao;
import br.com.flygonow.dao.ProductDao;
import br.com.flygonow.dao.TabletDao;
import br.com.flygonow.dao.ClientDao;
import br.com.flygonow.entities.Atendente;
import br.com.flygonow.entities.ItensPedido;
import br.com.flygonow.entities.Order;
import br.com.flygonow.entities.Product;
import br.com.flygonow.entities.Tablet;
import br.com.flygonow.entities.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPedidoItens {

	private OrderDao pedidoDao;

	@Resource
	public void setPedidoDao(OrderDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}

	private ItensPedidoDao itensPedidoDao;

	@Resource
	public void setItensPedidoDao(ItensPedidoDao itensPedidoDao) {
		this.itensPedidoDao = itensPedidoDao;
	}

	private ProductDao produtoDao;

	@Resource
	public void setProdutoDao(ProductDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	private ClientDao clienteDao;

	@Resource
	public void setUsuarioDao(ClientDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	private AtendenteDao atendenteDao;
	
	@Resource
	public void setAtendenteDao(AtendenteDao atendenteDao) {
		this.atendenteDao = atendenteDao;
	}

	private TabletDao tabletDao;
	
	@Resource
	public void setTablet(TabletDao tabletDao) {
		this.tabletDao = tabletDao;
	}

	@Test
	public void testSalvar() {
		Product produto = produtoDao.pesquisarPorId(1L);
		Client cliente = clienteDao.pesquisarPorId(1L);
		Atendente atendente = atendenteDao.pesquisarPorId(1L);
		Tablet tablet = tabletDao.pesquisarPorId(3L);

		Order pedido = new Order();

		pedido.setCcNumero("1");
		pedido.setCcNome("Order");
		
		pedido.setCliente(cliente);
		// simula o atendente 
		pedido.setAtendente(atendente);
		// simula o tablet 
		pedido.setTablet(tablet);
		// data atual
		pedido.setDataPed(new Timestamp((new Date()).getTime()));

		// salva o pedido para recuperar o id que sera armazenado nos itens
		Order pedidoConfirmado = pedidoDao.salvar(pedido);

		ItensPedido itemP = itensPedidoDao.salvar(new ItensPedido(2, 12.5,
				pedidoConfirmado.getId(), produto.getId()));

		Product produto2 = produtoDao.pesquisarPorId(2L);

		ItensPedido itemP2 = itensPedidoDao.salvar(new ItensPedido(1, 9.5,
				pedidoConfirmado.getId(), produto2.getId()));

		assertNotNull(itemP);
		assertNotNull(itemP2);

	}

}
