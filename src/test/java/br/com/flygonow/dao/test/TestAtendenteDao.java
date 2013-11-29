package br.com.flygonow.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.flygonow.dao.AtendenteDao;
import br.com.flygonow.entities.Atendente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAtendenteDao {

	private AtendenteDao atendenteDao;
	private Long id = 1L;

	@Autowired
	public void setAtendenteDao(AtendenteDao atendenteDao) {
		this.atendenteDao = atendenteDao;
	}

	private Atendente getAtendente() {
		Atendente atendente = new Atendente();
		atendente.setNome("Atendente");
		atendente.setSenha("key");
		return atendente;
	}

	@Test
	public void testSalvar() {
		System.out.println(this.getClass().getClassLoader());

		Atendente atendente = null;
		atendente = atendenteDao.salvar(getAtendente());
		assertNotNull(atendente);
		assertEquals(id, atendente.getId());
		assertEquals("Atendente", atendente.getNome());
		assertEquals("key", atendente.getSenha());
	}
}
