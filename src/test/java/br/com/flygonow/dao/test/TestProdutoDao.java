package br.com.flygonow.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.flygonow.dao.CategoryDao;
import br.com.flygonow.dao.ProductDao;
import br.com.flygonow.entities.Category;
import br.com.flygonow.entities.Product;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/applicationContext.xml"})
@FixMethodOrder(MethodSorters.DEFAULT)
public class TestProdutoDao {

    private ProductDao produtoDao;
    private Long id = 2L;
	
    @Resource
    public void setProdutoDao(ProductDao produtoDao) {
        this.produtoDao = produtoDao;
    }    

    private CategoryDao categoriaDao;
	
    @Resource
    public void setCategoriaDao(CategoryDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
    
    private Product getProduto() {
		Product produto = new Product();
		Category categoria = categoriaDao.salvar(getCategoria());
		
		produto.setProdNome("Product");
		produto.setPreco(15.5);
		produto.setDesconto(5.0);
		
		produto.setCat(categoria);
		
		return produto;
	}
    
	private Category getCategoria() {
		Category categoria = new Category();
		categoria.setCatNome("Prod");
		return categoria;
	}
    
	@Test
	public void testSalvar() {
		Product produto = null;
		produto = produtoDao.salvar(getProduto());
		assertNotNull(produto);
		assertEquals(id, produto.getId());
		assertEquals("Teste", produto.getProdNome());
		
	}
	/*
	@Test
	public void testAtualizar() {
        Category cat = categoriaDao.pesquisarPorId(id);
        Product produto = produtoDao.pesquisarPorId(id);
        produto.setCat(cat);
        produto.setProdNome("Teste 2");
        
        produto = produtoDao.atualizar(produto);
        assertNotNull(produto);
        assertEquals("Teste 2", produto.getProdNome());
	}

	@Test
	public void testTodos() {
		List<Product> produtos = produtoDao.todos();
		assertNotNull(produtos);
		assertEquals(1, produtos.size());	
		assertEquals("Teste 2", produtos.get(0).getProdNome());
		
	}
	
	@Test
	public void testListPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		List<Product> produtos = produtoDao.listPesqParam("SELECT p FROM Product p WHERE p.id=:id", params);
		assertNotNull(produtos);
		assertEquals(1, produtos.size());	
		assertEquals("Teste 2", produtos.get(0).getProdNome());
		
	}

	@Test
	public void testExcluir() {
		Product produto = produtoDao.pesquisarPorId(id);
		produtoDao.excluir(produto);
		assertNull(produtoDao.pesquisarPorId(id));
	}
	*/	
}