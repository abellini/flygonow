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

import br.com.flygonow.dao.CoinDao;
import br.com.flygonow.entities.Coin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@FixMethodOrder(MethodSorters.DEFAULT)
public class TestMoedaDao {

	private CoinDao moedaDao;
	private Long id = 1L;
	private Double valor = 0.0;
	
	@Autowired
	public void setMoedaDao(CoinDao moedaDao) {
		this.moedaDao = moedaDao;
	}

	private Coin getMoeda(){
		Coin moeda = new Coin();
		moeda.setName("Real");
		moeda.setSimbol("R$");
		moeda.setVl_conversao(0.0);
		return moeda;
	}
	
	@Test
	public void testSalvar() {
		Coin moeda = null;
		moeda = moedaDao.salvar(getMoeda());
		assertNotNull(moeda);
		assertEquals(id, moeda.getId());
		assertEquals("Real", moeda.getName());
		assertEquals("R$", moeda.getSimbol());
		assertEquals(valor, moeda.getVl_conversao());
	}

}
