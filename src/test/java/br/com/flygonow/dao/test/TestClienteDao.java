package br.com.flygonow.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.flygonow.dao.ClientDao;
import br.com.flygonow.entities.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClienteDao {

	private ClientDao usuarioDao;
	private Long id = 2L;

	@Autowired
	public void setUsuarioDao(ClientDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	private Client getCliente() {
		Client usuario = new Client();
		usuario.setNome("User");
		usuario.setEmail("user@user.com");
		usuario.setSenha("teste");
		return usuario;
	}
	
	@Test()
	public void testSalvar() {
		Client usuario = null;
		usuario = usuarioDao.salvar(getCliente());
		assertNotNull(usuario);
		assertEquals(id, usuario.getId());
		assertEquals("User", usuario.getNome());
		assertEquals("user@user.com", usuario.getEmail());
		assertEquals("teste", usuario.getSenha());
	}

	/*@Test
	public void testAtualizar() {
        Client cliente = usuarioDao.pesquisarPorId(id);
        cliente.setNome("User 2");
        cliente.setSenha("key_teste");

        cliente = usuarioDao.atualizar(cliente);
        assertNotNull(cliente);
        assertEquals("User 2", cliente.getNome());
        assertEquals("key_teste", cliente.getSenha());
	}
	
	@Test
	public void testTodos() {
		List<Client> users = usuarioDao.todos();
		assertNotNull(users);
		assertEquals(6, users.size());	
		assertEquals("User", users.get(0).getNome());
		assertEquals("User 2", users.get(1).getNome());
	}
	
	@Test
	public void testListPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		List<Usuario> users = 
				clienteDao.
			listPesqParam("SELECT p FROM Client p WHERE p.id=:id", params);
		assertNotNull(users);
		assertEquals(1, users.size());	
		assertEquals("User 2", users.get(0).getNome());
	}
	
	@Test
	public void testPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		Usuario user = 
			clienteDao.
			pesqParam("SELECT p FROM Usuario p WHERE p.id=:id", params);
		assertNotNull(user);
		assertEquals("User 2", user.getNome());
		
	}	
	
	@Test
	public void testExcluir() {
		CLiente cliente = clienteDao.pesquisarPorId(id);
		usuarioDao.excluir(cliente);
		assertNull(clienteDao.pesquisarPorId(id));
	}	
	*/
}