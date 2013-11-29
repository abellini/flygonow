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

import br.com.flygonow.dao.CategoryDao;
import br.com.flygonow.entities.Category;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCategoriaDao {

    private CategoryDao categoriaDao;
    private Long id = 4L;
	
    @Autowired
    public void setCategoriaDao(CategoryDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
    
    private Category getCategoria() {
		Category categoria = new Category();
		categoria.setCatNome("Teste");
		return categoria;
	}

	@Test
	public void testSalvar() {
		System.out.println(this.getClass().getClassLoader());
    	
		Category categoria = null;
		categoria = categoriaDao.salvar(getCategoria());
		assertNotNull(categoria);
		assertEquals(id, categoria.getId());
		assertEquals("Teste", categoria.getCatNome());
		
	}
	
	@Test
	public void testAtualizar() {
        Category categoria = categoriaDao.pesquisarPorId(id);
        categoria.setCatNome("Teste 2");

        categoria = categoriaDao.atualizar(categoria);
        assertNotNull(categoria);
        assertEquals("Teste 2", categoria.getCatNome());

	}

	@Test
	public void testTodos() {
		List<Category> categorias = categoriaDao.todos();
		assertNotNull(categorias);
		assertEquals(3, categorias.size());	
		assertEquals("Teste", categorias.get(0).getCatNome());
		
	}
	
	@Test
	public void testListPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		List<Category> categorias = 
			categoriaDao.
			listPesqParam("SELECT p FROM Category p WHERE p.id=:id", params);
		assertNotNull(categorias);
		assertEquals(1, categorias.size());	
		assertEquals("Teste 2", categorias.get(0).getCatNome());
		
	}
    
	@Test
	public void testPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		Category categoria = 
			categoriaDao.
			pesqParam("SELECT p FROM Category p WHERE p.id=:id", params);
		assertNotNull(categoria);
		assertEquals("Teste 2", categoria.getCatNome());
		
	}	
	
	@Test
	public void testExcluir() {
		Category categoria = categoriaDao.pesquisarPorId(id);
		categoriaDao.excluir(categoria);
		assertNull(categoriaDao.pesquisarPorId(id));
	}	
}