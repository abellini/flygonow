package br.com.flygonow.entities;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Categorias")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="categoria_gen")	
	@SequenceGenerator(name = "categoria_gen", sequenceName = "seq_categoria")
	private Long id;

	@Column(name="cat_nome")
	private String catNome;

	@Column(name="imagem")
	private byte[] imagem;
	
	@Column(name="descricao")
	private String descricao;
	
	@OneToMany(mappedBy="cat", fetch = LAZY, cascade = ALL)    
	private Set<Produto> produtos;

	public Categoria() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCatNome() {
		return this.catNome;
	}

	public void setCatNome(String catNome) {
		this.catNome = catNome;
	}
	
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

}
