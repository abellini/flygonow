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

import br.com.flygonow.dao.CategoriaDao;
import br.com.flygonow.dao.ProdutoDao;
import br.com.flygonow.entities.Categoria;
import br.com.flygonow.entities.Produto;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/applicationContext.xml"})
@FixMethodOrder(MethodSorters.DEFAULT)
public class TestProdutoDao {

    private ProdutoDao produtoDao;
    private Long id = 2L;
	
    @Resource
    public void setProdutoDao(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }    

    private CategoriaDao categoriaDao;
	
    @Resource
    public void setCategoriaDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
    
    private Produto getProduto() {
		Produto produto = new Produto();
		Categoria categoria = categoriaDao.salvar(getCategoria());
		
		produto.setProdNome("Produto");
		produto.setPreco(15.5);
		produto.setDesconto(5.0);
		
		produto.setCat(categoria);
		
		return produto;
	}
    
	private Categoria getCategoria() {
		Categoria categoria = new Categoria();
		categoria.setCatNome("Prod");
		return categoria;
	}
    
	@Test
	public void testSalvar() {
		Produto produto = null;
		produto = produtoDao.salvar(getProduto());
		assertNotNull(produto);
		assertEquals(id, produto.getId());
		assertEquals("Teste", produto.getProdNome());
		
	}
	/*
	@Test
	public void testAtualizar() {
        Categoria cat = categoriaDao.pesquisarPorId(id);
        Produto produto = produtoDao.pesquisarPorId(id);
        produto.setCat(cat);
        produto.setProdNome("Teste 2");
        
        produto = produtoDao.atualizar(produto);
        assertNotNull(produto);
        assertEquals("Teste 2", produto.getProdNome());
	}

	@Test
	public void testTodos() {
		List<Produto> produtos = produtoDao.todos();
		assertNotNull(produtos);
		assertEquals(1, produtos.size());	
		assertEquals("Teste 2", produtos.get(0).getProdNome());
		
	}
	
	@Test
	public void testListPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		List<Produto> produtos = produtoDao.listPesqParam("SELECT p FROM Produto p WHERE p.id=:id", params);
		assertNotNull(produtos);
		assertEquals(1, produtos.size());	
		assertEquals("Teste 2", produtos.get(0).getProdNome());
		
	}

	@Test
	public void testExcluir() {
		Produto produto = produtoDao.pesquisarPorId(id);
		produtoDao.excluir(produto);
		assertNull(produtoDao.pesquisarPorId(id));
	}
	*/	
}