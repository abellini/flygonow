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
import br.com.flygonow.dao.PedidoDao;
import br.com.flygonow.dao.ProdutoDao;
import br.com.flygonow.dao.TabletDao;
import br.com.flygonow.dao.ClienteDao;
import br.com.flygonow.entities.Atendente;
import br.com.flygonow.entities.ItensPedido;
import br.com.flygonow.entities.Pedido;
import br.com.flygonow.entities.Produto;
import br.com.flygonow.entities.Tablet;
import br.com.flygonow.entities.Cliente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPedidoItens {

	private PedidoDao pedidoDao;

	@Resource
	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}

	private ItensPedidoDao itensPedidoDao;

	@Resource
	public void setItensPedidoDao(ItensPedidoDao itensPedidoDao) {
		this.itensPedidoDao = itensPedidoDao;
	}

	private ProdutoDao produtoDao;

	@Resource
	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	private ClienteDao clienteDao;

	@Resource
	public void setUsuarioDao(ClienteDao clienteDao) {
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
		Produto produto = produtoDao.pesquisarPorId(1L);
		Cliente cliente = clienteDao.pesquisarPorId(1L);
		Atendente atendente = atendenteDao.pesquisarPorId(1L);
		Tablet tablet = tabletDao.pesquisarPorId(3L);

		Pedido pedido = new Pedido();

		pedido.setCcNumero("1");
		pedido.setCcNome("Pedido");
		
		pedido.setCliente(cliente);
		// simula o atendente 
		pedido.setAtendente(atendente);
		// simula o tablet 
		pedido.setTablet(tablet);
		// data atual
		pedido.setDataPed(new Timestamp((new Date()).getTime()));

		// salva o pedido para recuperar o id que sera armazenado nos itens
		Pedido pedidoConfirmado = pedidoDao.salvar(pedido);

		ItensPedido itemP = itensPedidoDao.salvar(new ItensPedido(2, 12.5,
				pedidoConfirmado.getId(), produto.getId()));

		Produto produto2 = produtoDao.pesquisarPorId(2L);

		ItensPedido itemP2 = itensPedidoDao.salvar(new ItensPedido(1, 9.5,
				pedidoConfirmado.getId(), produto2.getId()));

		assertNotNull(itemP);
		assertNotNull(itemP2);

	}

}
