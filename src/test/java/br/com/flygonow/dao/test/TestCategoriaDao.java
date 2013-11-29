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

import br.com.flygonow.dao.CategoriaDao;
import br.com.flygonow.entities.Categoria;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCategoriaDao {

    private CategoriaDao categoriaDao;
    private Long id = 4L;
	
    @Autowired
    public void setCategoriaDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
    
    private Categoria getCategoria() {
		Categoria categoria = new Categoria();
		categoria.setCatNome("Teste");
		return categoria;
	}

	@Test
	public void testSalvar() {
		System.out.println(this.getClass().getClassLoader());
    	
		Categoria categoria = null;
		categoria = categoriaDao.salvar(getCategoria());
		assertNotNull(categoria);
		assertEquals(id, categoria.getId());
		assertEquals("Teste", categoria.getCatNome());
		
	}
	
	@Test
	public void testAtualizar() {
        Categoria categoria = categoriaDao.pesquisarPorId(id);
        categoria.setCatNome("Teste 2");

        categoria = categoriaDao.atualizar(categoria);
        assertNotNull(categoria);
        assertEquals("Teste 2", categoria.getCatNome());

	}

	@Test
	public void testTodos() {
		List<Categoria> categorias = categoriaDao.todos();
		assertNotNull(categorias);
		assertEquals(3, categorias.size());	
		assertEquals("Teste", categorias.get(0).getCatNome());
		
	}
	
	@Test
	public void testListPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		List<Categoria> categorias = 
			categoriaDao.
			listPesqParam("SELECT p FROM Categoria p WHERE p.id=:id", params);
		assertNotNull(categorias);
		assertEquals(1, categorias.size());	
		assertEquals("Teste 2", categorias.get(0).getCatNome());
		
	}
    
	@Test
	public void testPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		Categoria categoria = 
			categoriaDao.
			pesqParam("SELECT p FROM Categoria p WHERE p.id=:id", params);
		assertNotNull(categoria);
		assertEquals("Teste 2", categoria.getCatNome());
		
	}	
	
	@Test
	public void testExcluir() {
		Categoria categoria = categoriaDao.pesquisarPorId(id);
		categoriaDao.excluir(categoria);
		assertNull(categoriaDao.pesquisarPorId(id));
	}	
}