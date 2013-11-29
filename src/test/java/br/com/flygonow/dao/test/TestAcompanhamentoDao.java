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

import br.com.flygonow.dao.AcompanhamentoDao;
import br.com.flygonow.entities.Acompanhamento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAcompanhamentoDao {

	private AcompanhamentoDao acompanhamentoDao;
	private Long id = 4L;
	private Double preco = 10.00;

	@Autowired
	public void setAcompanhamentoDao(AcompanhamentoDao acompanhamentoDao) {
		this.acompanhamentoDao = acompanhamentoDao;
	}
	
	private Acompanhamento getAcompanhamento() {
		Acompanhamento acomp = new Acompanhamento();
		acomp.setAcompNome("Acompanhamento");
		acomp.setDescricao("descrição");
		acomp.setPreco(preco);
		return acomp;
	}

	@Test
	public void testSalvar() {
		System.out.println(this.getClass().getClassLoader());

		Acompanhamento acomp = null;
		acomp = acompanhamentoDao.salvar(getAcompanhamento());
		assertNotNull(acomp);
		assertEquals(id, acomp.getId());
		assertEquals("Acompanhamento", acomp.getAcompNome());
		assertEquals("descrição", acomp.getDescricao());
		assertEquals(preco, acomp.getPreco());
	}

}
