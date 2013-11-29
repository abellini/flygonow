package br.com.flygonow.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.flygonow.dao.AtendenteDao;
import br.com.flygonow.dao.TabletDao;
import br.com.flygonow.entities.Atendente;
import br.com.flygonow.entities.Tablet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTabletDao {

	private TabletDao tabletDao;
	private Long id = 3L;
	private Integer numero = 3;

	@Autowired
	public void setTablet(TabletDao tabletDao) {
		this.tabletDao = tabletDao;
	}

	private AtendenteDao atendenteDao;

	@Resource
	public void setAtendenteDao(AtendenteDao atendenteDao) {
		this.atendenteDao = atendenteDao;
	}

	private Tablet getTablet() {
		Tablet tablet = new Tablet();
		tablet.setNumero(numero);
		tablet.setServerIP("192.168.0.3");

		Atendente atendente = atendenteDao.pesquisarPorId(1L);
		tablet.setAtendente(atendente);

		return tablet;
	}

	@Test
	public void testSalvar() {
		System.out.println(this.getClass().getClassLoader());

		Tablet tablet = null;
		tablet = tabletDao.salvar(getTablet());
		assertNotNull(tablet);
		assertEquals(id, tablet.getId());
		assertEquals(numero, tablet.getNumero());
		assertEquals("192.168.0.3", tablet.getServerIP());
	}

}
