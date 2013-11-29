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

import br.com.flygonow.dao.AdminDao;
import br.com.flygonow.entities.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@FixMethodOrder(MethodSorters.DEFAULT)
public class TestAdminDao {

	private AdminDao adminDao;
	private Long id = 1L;
	
	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	private Admin getAdmin() {
		Admin admin = new Admin();
		admin.setLogin("Admin");
		admin.setSenha("teste_admin");
		return admin;
	}

	@Test
	public void testSalvar() {
		Admin admin = null;
		admin = adminDao.salvar(getAdmin());
		assertNotNull(admin);
		assertEquals(id, admin.getId());
		assertEquals("Admin", admin.getLogin());
		assertEquals("teste_admin", admin.getSenha());
	}
	
	@Test
	public void testAtualizar() {
		Admin admin = adminDao.pesquisarPorId(id);
		admin.setSenha("key");

		admin = adminDao.atualizar(admin);
        assertNotNull(admin);
        assertEquals("key", admin.getSenha());
	}
	
	@Test
	public void testTodos() {
		List<Admin> admins = adminDao.todos();
		assertNotNull(admins);
		assertEquals(2, admins.size());	
		assertEquals("Admin", admins.get(0).getLogin());
	}
	
	@Test
	public void testListPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		List<Admin> admins = 
				adminDao.
			listPesqParam("SELECT p FROM Admin p WHERE p.id=:id", params);
		assertNotNull(admins);
		assertEquals(2, admins.size());	
		assertEquals("key", admins.get(0).getSenha());
	}
	
	@Test
	public void testPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		Admin admin = 
			adminDao.
			pesqParam("SELECT p FROM Admin p WHERE p.id=:id", params);
		assertNotNull(admin);
		assertEquals("Admin", admin.getLogin());
		assertEquals("key", admin.getSenha());
	}	
	
	@Test
	public void testExcluir() {
		Admin admin = adminDao.pesquisarPorId(id);
		adminDao.excluir(admin);
		assertNull(adminDao.pesquisarPorId(id));
	}
	
}
